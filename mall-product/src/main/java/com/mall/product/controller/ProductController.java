package com.mall.product.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.common.domain.PageDTO;
import com.mall.common.domain.PageQuery;
import com.mall.common.result.Result;
import com.mall.product.pojo.dto.ProductDTO;
import com.mall.product.pojo.dto.QueryProductParams;
import com.mall.product.pojo.entity.Product;
import com.mall.product.pojo.vo.PageVO;
import com.mall.product.pojo.vo.ProductVO;
import com.mall.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products/api")
@Tag(name = "ProductController", description = "商品服务接口")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @Operation(summary = "条件查询", description = "根据条件分页查询商品列表")
    @PostMapping("/select/query")
    public Result<PageVO<ProductVO>> getProducts(@RequestBody QueryProductParams query) {
        try {
            PageVO<ProductVO> res = productService.getProducts(query);
            return Result.success(res);
        } catch (IOException e) {
            return Result.error("ES查询失败");
        }
    }

    @Operation(summary = "获取搜索建议", description = "根据关键词获取搜索建议")
    @PostMapping("/select/recommends")
    public Result<List<String>> getRecommends(@RequestBody QueryProductParams query) {
        try {
            List<String> res = productService.getRecommends(query);
            return Result.success(res);
        } catch (IOException e) {
            return Result.error("查询建议获取失败");
        }
    }

    @Operation(summary = "获取商品详情", description = "根据ID获取商品详细信息")
    @GetMapping("/select/{id}")
    public Result<ProductDTO> getById(
            @Parameter(description = "商品ID", required = true, example = "1")
            @PathVariable Long id) {
        Product product = productService.getById(id);
        return Result.success(convertToDTO(product));
    }

    @Operation(summary = "获取所有商品", description = "获取全部商品列表")
    @GetMapping("/select")
    public Result<List<ProductDTO>> list() {
        List<Product> products = productService.list();
        List<ProductDTO> dtos = products.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return Result.success(dtos);
    }

    @Operation(summary = "新增商品", description = "创建新的商品信息")
    @PostMapping
    public Result save(
            @Parameter(description = "商品信息", required = true)
            @RequestBody ProductDTO productDTO) {
        log.info("新增商品:{}", productDTO);
        productService.saveProduct(productDTO);
        return Result.success();
    }

    @Operation(summary = "删除商品", description = "根据ID删除商品")
    @DeleteMapping("/{id}")
    public Result remove(
            @Parameter(description = "商品ID", required = true, example = "1")
            @PathVariable Long id) {
        log.info("删除商品:{}", id);
        productService.removeProduct(id);
        return Result.success();
    }

    @Operation(summary = "更新商品", description = "更新商品详细信息")
    @PutMapping
    public Result update(
            @Parameter(description = "商品信息", required = true)
            @RequestBody ProductDTO productDTO) {
        log.info("更新商品信息:{}", productDTO);
        productService.updateProduct(productDTO);
        return Result.success();
    }

    @Operation(summary = "分页查询", description = "通用商品分页查询")
    @GetMapping("/select/page")
    public Result<PageDTO<ProductDTO>> queryProductByPage(
            @Parameter(description = "分页参数") PageQuery query) {
        Page<Product> result = productService.page(query.toMpPage("update_time", false));
        PageDTO<ProductDTO> pageDTO = PageDTO.of(result, ProductDTO.class);
        pageDTO.getList().forEach(ProductDTO::getPriceYuan);
        return Result.success(pageDTO);
    }

    @Operation(summary = "分类分页查询", description = "按分类分页查询商品")
    @GetMapping("/select/page/{categoryId}")
    public Result<PageDTO<ProductDTO>> queryProductWithCategoryByPage(
            @Parameter(description = "分页参数") PageQuery query,
            @Parameter(description = "分类ID", required = true, example = "101")
            @PathVariable Long categoryId) {
        log.info("按类型：{}查找商品：{}", categoryId, query);
        return Result.success(productService.queryProductWithCategoryByPage(query, categoryId));
    }

    private ProductDTO convertToDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        BeanUtil.copyProperties(product, dto);
        return dto;
    }

    @GetMapping("/check/{productId}")
    public boolean checkProductExists(@PathVariable Long productId) {
        boolean exists = productService.checkProductExists(productId);
        return exists;
    }
}