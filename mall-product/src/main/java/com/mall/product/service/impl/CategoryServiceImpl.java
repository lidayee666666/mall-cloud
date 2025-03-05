package com.mall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mall.api.client.StoreClient;
import com.mall.api.client.UserClient;
import com.mall.api.domain.entity.Staff;
import com.mall.api.domain.entity.User;
import com.mall.common.constant.MessageConstant;
import com.mall.common.exception.CategoryUniqueException;
import com.mall.common.exception.UserPermissionException;
import com.mall.common.result.Result;
import com.mall.common.utils.UserContext;
import com.mall.product.mapper.CategoryMapper;
import com.mall.product.pojo.entity.Category;
import com.mall.product.pojo.entity.Product;
import com.mall.product.service.CategoryService;
import com.mall.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    private final UserClient userClient;

    private final ProductService productService;
    @Override
    public void saveCategory(Category category) {
        if(!checkRole()) {
            throw new UserPermissionException(MessageConstant.USER_PERMISSION_ERROR);
        }

        String name = category.getCategory();
        LambdaQueryWrapper<Category> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Category::getCategory, name);
        Category one = getOne(wrapper);
        if(one != null) {
            throw new CategoryUniqueException(MessageConstant.CATEGORY_ALREADY_EXISTS_ERROR);
        }

        save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        if(!checkRole()) {
            throw new UserPermissionException(MessageConstant.USER_PERMISSION_ERROR);
        }
        // TODO 该分类还有商品上架的时候不能删除
        removeById(id);
    }

    private boolean checkRole() {
        Long userId = UserContext.getUser();
        Result<User> result = userClient.getById(userId);
        User user = result.getData();
        return user.getPlatformAdmin();
    }
}
