package com.mall.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.mall.api.client.ProductClient;
import com.mall.common.utils.BeanUtils;
import com.mall.common.utils.UserContext;
import com.mall.user.domain.entity.Comment;
import com.mall.user.domain.vo.CommentVO;
import com.mall.user.mapper.CommentMapper;
import com.mall.user.mapper.UserMapper;
import com.mall.api.domain.entity.User;
import com.mall.user.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private ProductClient productClient;



    @Override
    public String findPasswordById(Long id) {
        // 1.根据用户名在数据库中查询用户
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        User user = userMapper.selectOne(queryWrapper);
        String password = user.getPassword();
        return password;
    }

    @Override
    public boolean savePwd(Long userId,String newPassword) {
        // 创建 QueryWrapper 对象
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        // 设置查询条件（例如根据用户ID）
        queryWrapper.eq("id", userId); // userId 是要修改密码的用户ID

        // 创建一个 User 对象，设置新的密码
        User updateUser = new User();
        updateUser.setPassword(newPassword); // newPassword 是新密码

        // 调用 MyBatis-Plus 的 update 方法进行更新
        boolean isUpdated = userMapper.update(updateUser, queryWrapper) > 0;
        return isUpdated;
    }

    @Override
    public Integer saveComment(@Param("userId") Long userId, @Param("productId") Long productId, @Param("content") String content, @Param("parentId") Long parentId) {
        // 判断商品是否存在
        boolean productExists = productClient.checkProductExists(productId);

        if (!productExists) {
            throw new RuntimeException("商品不存在");
        }

        // 创建 Comment 实体对象并设置属性
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setUserId(userId);
        comment.setProductId(productId);
        comment.setParentId(parentId);

        // 插入评论记录
        Integer status = commentMapper.insert(comment);

        if (parentId != null) {
            // 构造更新条件，使用 LambdaUpdateWrapper 避免硬编码
            LambdaUpdateWrapper<Comment> updateWrapper = new LambdaUpdateWrapper<>();
            updateWrapper.eq(Comment::getId, comment.getParentId()) // 更新条件：id 等于 parentId
                    .setSql("reply_count = reply_count + 1"); // 动态更新 reply_count

            // 执行更新操作
            commentMapper.update(null, updateWrapper);
        }

        return status;
    }


    @Override
    public List<CommentVO> findComment(Long productId) {
        try {
            // 查询所有一级评论（parent_id 为 null）
            List<Comment> firstCommentList = commentMapper.selectList(
                    new QueryWrapper<Comment>()
                            .eq("product_id", productId)
                            .isNull("parent_id").orderBy(true, false, "com_time")
            );

            // 转换为 CommentVO 列表
            List<CommentVO> commentVOList = BeanUtils.copyToList(firstCommentList, CommentVO.class);

            // 遍历 CommentVO 列表，补充用户信息
            for (CommentVO curr : commentVOList) {
                if (curr.getUserId() != null && curr.getUserId() > 0) {
                    User user = userMapper.selectById(curr.getUserId());
                    if (user != null) { // 防止 user 为 null
                        curr.setAvatar(user.getAvatar());
                        curr.setUsername(user.getUsername());
                    }
                }
            }
            return commentVOList;
        } catch (Exception e) {
            log.error("Error occurred while fetching comments for product ID: {}"+productId, e);
            throw new RuntimeException("Failed to fetch comments", e);
        }
    }

    @Override
    public List<CommentVO> findSecondComment(Long commentId) {
        List<Comment> subCommentList = commentMapper.selectList(
                new QueryWrapper<Comment>().eq("parent_id", commentId).orderBy(true, false, "com_time")
        );
        List<CommentVO> subCommentVOList = BeanUtils.copyToList(subCommentList, CommentVO.class);
        for (CommentVO subComment : subCommentVOList) {
            if (subComment.getUserId() != null && subComment.getUserId() > 0) {
                User user = userMapper.selectById(subComment.getUserId());
                if (user != null) {
                    subComment.setAvatar(user.getAvatar());
                    subComment.setUsername(user.getUsername());
                    subComment.setNickname(user.getNickname());
                }
            }
        }
        return subCommentVOList;
    }

    @Override
    public Map<String, Object> pwdInfo() {
        User user = this.getById(UserContext.getUser());
        // 构造返回数据
        Map<String, Object> response = new HashMap<>();
        response.put("username", user.getUsername());
        response.put("account", user.getUsername());
        return response;
    }

    @Override
    public Long getCommentCount(Long productId) {
        long res = commentMapper.selectList(new QueryWrapper<Comment>().eq("product_id", productId)).size();
        return res;
    }


}
