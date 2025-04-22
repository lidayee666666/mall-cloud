package com.mall.api.client;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.api.domain.dto.ProductDTO;
import com.mall.api.domain.entity.OrderDetailProduct;
import com.mall.common.domain.PageDTO;
import com.mall.common.domain.PageQuery;
import com.mall.common.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(value = "mall-product")
public interface ProductClient {

    @GetMapping("/products/order/api/{id}")
    Result<OrderDetailProduct> getById(@PathVariable("id") Long id);

    @GetMapping("/products/order/api/getProductByName/{name}")
    Result<OrderDetailProduct> getByName(@PathVariable("name") String name);

    @GetMapping("/products/api/check/{productId}")
    boolean checkProductExists(@PathVariable Long productId);


    @GetMapping("/products/api/select/{id}")
    Result<ProductDTO> getById(@PathVariable String id);



    @Operation(summary = "新增商品", description = "创建新的商品信息")
    @PostMapping("/products/api/add")
    Result save(
            @Parameter(description = "商品信息", required = true)
            @RequestBody ProductDTO productDTO);

    @Operation(summary = "删除商品", description = "根据ID删除商品")
    @DeleteMapping("/products/api/delete/{id}")
    Result remove(
            @Parameter(description = "商品ID", required = true, example = "1")
            @PathVariable Long id);

    @Operation(summary = "更新商品", description = "更新商品详细信息")
    @PutMapping("/products/api/update")
    Result update(@Parameter(description = "商品信息", required = true) @RequestBody ProductDTO productDTO);

    @Operation(summary = "分页查询", description = "通用商品分页查询")
    @GetMapping("/products/api/select/page/{category}")
    Result<PageDTO<ProductDTO>> queryProductByPage(
            @Parameter(description = "分页参数") PageQuery query, @PathVariable String category);


    @Operation(summary = "分页查询", description = "通用商品分页查询")
    @GetMapping("/products/api/select/page")
    Result<PageDTO<ProductDTO>> queryProductByPage(
            @Parameter(description = "分页参数") PageQuery query);

    @Operation(summary = "分类分页查询", description = "按分类分页查询商品")
    @GetMapping("/products/api/select/page/{categoryId}")
    Result<PageDTO<ProductDTO>> queryProductWithCategoryByPage(
            @Parameter(description = "分页参数") PageQuery query,
            @Parameter(description = "分类ID", required = true, example = "101")
            @PathVariable Long categoryId);

    @GetMapping("/products/order/api/decreProductStockByName/{name}")
    Integer decrement(@PathVariable("name")String name);
}
