package com.mall.product.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.common.domain.PageDTO;
import com.mall.common.domain.PageQuery;
import com.mall.common.result.Result;
import com.mall.product.pojo.dto.ProductDTO;
import com.mall.product.pojo.entity.Category;
import com.mall.product.pojo.entity.Product;
import com.mall.product.service.CategoryService;
import com.mall.product.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products/api")
@Api(tags = "商品服务接口")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/select/{id}")
    @ApiOperation("根据id查询商品")
    public Result<ProductDTO> getById(@PathVariable Long id) {
        Product product = productService.getById(id);
        return Result.success(convertToDTO(product));
    }

    @GetMapping("/select")
    @ApiOperation("获取所有商品")
    public Result<List<ProductDTO>> list() {
        List<Product> products = productService.list();
        List<ProductDTO> dtos = products.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return Result.success(dtos);
    }

    private ProductDTO convertToDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        BeanUtil.copyProperties(product, dto);
        return dto;
    }

    /**
     * 新增商品
     * @param productDTO
     * @return
     */
    @PostMapping
    @ApiOperation("新增商品")
    public Result save(@RequestBody ProductDTO productDTO) {
        log.info("新增商品:{}", productDTO);
        productService.saveProduct(productDTO);
        return Result.success();
    }

    /**
     * 删除商品
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ApiOperation("删除商品")
    public Result remove(@PathVariable Long id) {
        log.info("删除商品:{}", id);
        productService.removeProduct(id);
        return Result.success();
    }

    /**
     * 更新商品信息
     * @param productDTO
     * @return
     */
    @PutMapping
    @ApiOperation("更新商品信息")
    public Result update(@RequestBody ProductDTO productDTO) {
        log.info("更新商品信息:{}", productDTO);
        productService.updateProduct(productDTO);
        return Result.success();
    }

    /**
     * 分页查询商品
     * @param query
     * @return
     */
    @ApiOperation("分页查询商品")
    @GetMapping("/select/page")
    public Result<PageDTO<ProductDTO>> queryProductByPage(PageQuery query) {
        // 1.分页查询
        Page<Product> result = productService.page(query.toMpPage("update_time", false));
        // 2.封装并返回
        PageDTO<ProductDTO> pageDTO = PageDTO.of(result, ProductDTO.class);
        pageDTO.getList().forEach(dto -> dto.getPriceYuan());
        return Result.success(pageDTO);
    }

    /**
     * 按照类型分页查询商品
     * @param query
     * @param categoryId
     * @return
     */
    @ApiOperation("按类型查找商品")
    @GetMapping("/select/page/{categoryId}")
    public Result<PageDTO<ProductDTO>> queryProductWithCategoryByPage(PageQuery query, @PathVariable Long categoryId) {
        log.info("按类型：{}查找商品：{}", categoryId, query);
        PageDTO<ProductDTO> pageDTO = productService.queryProductWithCategoryByPage(query, categoryId);
        return Result.success(pageDTO);
    }
}
