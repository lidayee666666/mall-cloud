package com.mall.product.controller;

import com.mall.common.result.Result;
import com.mall.product.pojo.entity.Category;
import com.mall.product.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/api/categories")
@Tag(name = "CategoryController", description = "商品分类管理接口")
@Slf4j
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @Operation(summary = "创建分类", description = "创建新的商品分类")
    @PostMapping
    public Result saveCategory(
            @Parameter(description = "分类信息", required = true)
            @RequestBody Category category) {
        log.info("新增种类：{}", category);
        categoryService.saveCategory(category);
        return Result.success();
    }

    @Operation(summary = "删除分类", description = "根据ID删除商品分类")
    @DeleteMapping("/{id}")
    public Result deleteCategory(
            @Parameter(description = "分类ID", required = true, example = "1")
            @PathVariable Long id) {
        log.info("删除商品种类：{}", id);
        categoryService.deleteCategory(id);
        return Result.success();
    }

    @Operation(summary = "获取全部分类", description = "获取所有商品分类列表")
    @GetMapping("/select")
    public Result<List<Category>> list() {
        log.info("查询所有分类");
        return Result.success(categoryService.list());
    }
}