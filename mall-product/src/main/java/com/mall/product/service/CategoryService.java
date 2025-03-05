package com.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.product.pojo.entity.Category;

public interface CategoryService extends IService<Category> {
    void saveCategory(Category category);

    void deleteCategory(Long id);
}
