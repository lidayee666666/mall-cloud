package com.mall.store.controller;


import com.mall.api.client.ProductClient;
import com.mall.api.domain.dto.ProductDTO;
import com.mall.common.domain.PageDTO;
import com.mall.common.domain.PageQuery;
import com.mall.common.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 李青龙
 * @date 2025/04/13 14:49
 * 功能描述:
 */
@Slf4j
@RestController
@RequestMapping("/store/api/productAdmin")
public class StoreProductController {

    @Autowired
    ProductClient productClient;

    @Operation(summary = "获取商品详情", description = "根据ID获取商品详细信息")
    @GetMapping("/getByProductId/{id}")
    public Result<ProductDTO> getById(
            @Parameter(description = "商品ID", required = true, example = "1")
            @PathVariable Long id) {

        return productClient.getById(String.valueOf(id));
    }


    @Operation(summary = "新增商品", description = "创建新的商品信息")
    @PostMapping("/add")
    public Result save(
            @Parameter(description = "商品信息", required = true)
            @RequestBody ProductDTO productDTO) {
        try {
            productClient.save(productDTO);
        }catch (RuntimeException e){
            log.debug("商品保存失败");
            throw new RuntimeException("商品保存失败");
        }

        return Result.success();
    }

    @Operation(summary = "删除商品", description = "根据ID删除商品")
    @DeleteMapping("delete/{id}")
    public Result remove(
            @Parameter(description = "商品ID", required = true, example = "1")
            @PathVariable Long id) {
        log.info("删除商品:{}", id);
        productClient.remove(id);
        return Result.success();
    }

    @Operation(summary = "更新商品", description = "更新商品详细信息")
    @PutMapping("update")
    public Result update(
            @Parameter(description = "商品信息", required = true)
            @RequestBody ProductDTO productDTO) {
        log.info("更新商品信息:{}", productDTO);
       productClient.update(productDTO);
        return Result.success();
    }

    @Operation(summary = "分页查询", description = "通用商品分页查询")
    @GetMapping("/select/page/{category}")
    public Result<PageDTO<ProductDTO>> queryProductByPage(
            @Parameter(description = "分页参数") PageQuery query, @PathVariable String category) {
        log.info("根据PageQuery和商品种类名称查询分页");
        return productClient.queryProductByPage(query,category);
    }

    @Operation(summary = "分页查询", description = "通用商品分页查询")
    @GetMapping("/select/page")
    public Result<PageDTO<ProductDTO>> queryProductByPage(
            @Parameter(description = "分页参数") PageQuery query) {
        log.info("根据PageQuery查询分页");
        return productClient.queryProductByPage(query);
    }

    @Operation(summary = "分类分页查询", description = "按分类分页查询商品")
    @GetMapping("/select/page/{categoryId}")
    public Result<PageDTO<ProductDTO>> queryProductWithCategoryByPage(
            @Parameter(description = "分页参数") PageQuery query,
            @Parameter(description = "分类ID", required = true, example = "101")
            @PathVariable Long categoryId) {
        log.info("按类型id：{}查找商品：{}", categoryId, query);
        return productClient.queryProductWithCategoryByPage(query,categoryId);
    }





}
