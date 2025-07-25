package com.mall.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.api.domain.entity.User;
import com.mall.user.domain.vo.CommentVO;

import java.util.List;
import java.util.Map;

public interface UserService extends IService<User> {
    String findPasswordById(Long id);

    boolean savePwd(Long userId,String newPassword);

    Integer saveComment(Long userId,Long productId, String content, Long parentId);

    List<CommentVO> findComment(Long productId);

    List<CommentVO> findSecondComment(Long commentId);

    Map<String, Object> pwdInfo();

    Long getCommentCount(Long productId);

    List<CommentVO> findUserComment();
}
