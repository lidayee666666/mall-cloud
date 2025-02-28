package com.mall.product.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.common.domain.PageDTO;
import com.mall.common.domain.PageQuery;
import com.mall.common.result.Result;
import com.mall.product.pojo.dto.ProductDTO;
import com.mall.product.pojo.entity.Product;
import com.mall.product.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/api")
@Api(tags = "商品服务接口")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 第一个测试接口
     * @return
     */
    @GetMapping("/hello")
    @ApiOperation("初始化测试接口")
    public Result<String> hello() {
        log.info("hello world");
        return Result.success("hello world");
    }

    /**
     * 获取所有商品列表
     * @return
     */
    @GetMapping("/select")
    @ApiOperation("获取所有商品")
    public Result<List<Product>> list() {
        log.info("获取所有商品");
        List<Product> list = productService.list();
        return Result.success(list);
    }

    /**
     * 根据id查询商品
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation("根据id查询商品")
    public Result<Product> getById(@PathVariable Long id) {
        log.info("根据id查询商品:{}", id);
        Product product = productService.getById(id);
        return Result.success(product);
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
    @GetMapping("/page")
    public Result<PageDTO<ProductDTO>> queryProductByPage(PageQuery query) {
        // 1.分页查询
        Page<Product> result = productService.page(query.toMpPage("update_time", false));
        // 2.封装并返回
        PageDTO<ProductDTO> pageDTO = PageDTO.of(result, ProductDTO.class);
        return Result.success(pageDTO);
    }
}
