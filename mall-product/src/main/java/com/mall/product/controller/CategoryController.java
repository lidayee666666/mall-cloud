package com.mall.product.controller;

import com.mall.common.result.Result;
import com.mall.product.pojo.entity.Category;
import com.mall.product.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/api/categories")
@Slf4j
@Api(tags = "商品种类相关接口")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @ApiOperation("新增商品种类")
    @PostMapping
    public Result saveCategory(@RequestBody Category category) {
        log.info("新增种类：{}", category);
        categoryService.saveCategory(category);
        return Result.success();
    }

    @ApiOperation("删除商品种类")
    @DeleteMapping("/{id}")
    public Result deleteCategory(@PathVariable Long id) {
        log.info("删除商品种类：{}", id);
        categoryService.deleteCategory(id);
        return Result.success();
    }

    @ApiOperation("查询所有分类")
    @GetMapping("/select")
    public Result<List<Category>> list() {
        log.info("查询所有分类");
        List<Category> list = categoryService.list();
        return Result.success(list);
    }
}
