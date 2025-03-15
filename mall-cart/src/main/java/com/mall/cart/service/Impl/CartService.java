package com.mall.cart.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mall.api.client.ProductClient;
import com.mall.api.domain.entity.OrderDetailProduct;
import com.mall.cart.mapper.CartMapper;
import com.mall.cart.model.dto.CartAddDTO;
import com.mall.cart.model.dto.CartUpdateDTO;
import com.mall.cart.model.po.Cart;
import com.mall.cart.service.ICartService;
import com.mall.common.result.Result;
import com.mall.common.utils.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class CartService implements ICartService {
    @Autowired
    private CartMapper cartMapper;

    @Resource
    private ProductClient productClient;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Result<List<Cart>> getCartList() {
        Long id = UserContext.getUser();
        QueryWrapper<Cart> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", id);
        List<Cart> cartList = cartMapper.selectList(queryWrapper);
        return Result.success(cartList);
    }

    @Override
    @Transactional
    public Result<String> updateCartItem(CartUpdateDTO updateDTO) {
        // 1. 参数校验
        if (updateDTO == null || updateDTO.getProductId() == null || updateDTO.getQuantity() == null) {
            return Result.error("参数错误");
        }

        if (updateDTO.getQuantity() <= 0) {
            return Result.error("商品数量必须大于0");
        }

        // 2. 获取当前用户ID
        Long userId = UserContext.getUser();
        if (userId == null) {
            return Result.error("用户未登录");
        }

        // 3. 通过Feign调用商品服务，检查商品是否存在
        Result<OrderDetailProduct> productResult = productClient.getById(updateDTO.getProductId());
        if (productResult.getData() == null) {
            return Result.error("商品不存在");
        }
        OrderDetailProduct product = productResult.getData();

        // 4. 检查库存是否充足
        if (product.getStock() < updateDTO.getQuantity()) {
            return Result.error("库存不足");
        }

        // 5. 查找购物车项
        QueryWrapper<Cart> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId)
                .eq("product_id", updateDTO.getProductId());
        Cart cartItem = cartMapper.selectOne(queryWrapper);
        if (cartItem == null) {
            return Result.error("购物车中不存在该商品");
        }

        // 6. 更新数量
        cartItem.setNum(updateDTO.getQuantity());
        cartMapper.updateById(cartItem);

        // 7. 更新缓存
        updateCartCountCache(userId);

        // 8. 返回成功结果
        return Result.success("更新成功");
    }

    @Override
    public Result<String> deleteCartItem(Long productId) {
        // 1. 获取当前用户ID
        Long userId = UserContext.getUser();
        if (userId == null) {
            return Result.error("用户未登录");
        }

        // 2. 删除购物车项
        QueryWrapper<Cart> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId)
                .eq("product_id", productId);
        int deleteCount = cartMapper.delete(queryWrapper);
        if (deleteCount == 0) {
            return Result.error("购物车中不存在该商品");
        }

        // 3. 更新缓存
        updateCartCountCache(userId);

        return Result.success("删除成功");
    }

    @Override
    @Transactional
    public Result<String> addToCart(CartAddDTO addDTO) {
        // 0. 参数校验
        if (addDTO == null || addDTO.getProductId() == null) {
            return Result.error("参数错误");
        }
        // 设置默认数量为1
        if (addDTO.getNum() == null) {
            addDTO.setNum(1);
        }
        // 数量必须大于0
        if (addDTO.getNum() <= 0) {
            return Result.error("数量必须大于0");
        }

        // 1. 获取当前用户ID
        Long userId = UserContext.getUser();
        if (userId == null) {
            return Result.error("用户未登录");
        }

        // 2. 调用商品服务获取商品信息
        Result<OrderDetailProduct> productResult = productClient.getById(addDTO.getProductId());
        if (productResult == null || productResult.getCode() != 1 || productResult.getData() == null) {
            return Result.error("商品信息获取失败");
        }
        OrderDetailProduct product = productResult.getData();

        // 3. 检查库存是否充足
        if (product.getStock() < addDTO.getNum()) {
            return Result.error("库存不足");
        }

        // 4. 查找是否已存在购物车项
        QueryWrapper<Cart> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId)
                .eq("product_id", addDTO.getProductId())
                .isNull("deleted_at"); // 排除已删除的
        Cart cartItem = cartMapper.selectOne(queryWrapper);

        if (cartItem != null) {
            // 5. 如果存在，更新数量
            int newNum = cartItem.getNum() + addDTO.getNum();
            // 检查更新后的数量是否超过库存
            if (product.getStock() < newNum) {
                return Result.error("库存不足");
            }
            cartItem.setNum(newNum);
            cartItem.setUpdateTime(LocalDateTime.now());
            cartMapper.updateById(cartItem);
        } else {
            cartItem = new Cart();
            cartItem.setUserId(userId);
            cartItem.setProductId(addDTO.getProductId());
            cartItem.setNum(addDTO.getNum());
            cartItem.setName(product.getName());
            // 直接使用 product.getPrice()，无需转换
            cartItem.setPrice(product.getPrice());
            cartItem.setImage(product.getImage());
            cartItem.setAttributes(addDTO.getAttributes()); // 设置商品属性
            cartItem.setCreateTime(LocalDateTime.now());
            cartItem.setUpdateTime(LocalDateTime.now());
            cartMapper.insert(cartItem);
        }

        // 7. 更新缓存
        updateCartCountCache(userId);

        // 8. 返回成功结果
        return Result.success("添加成功");
    }

    @Override
    public Result<Integer> count() {
        Long userId = UserContext.getUser();
        if (userId == null) {
            return Result.error("用户未登录");
        }

        // 从缓存中获取购物车数量
        String cacheKey = "cart:count:" + userId;
        String cachedCount = stringRedisTemplate.opsForValue().get(cacheKey);
        if (cachedCount != null) {
            return Result.success(Integer.parseInt(cachedCount));
        }

        // 缓存未命中，查询数据库
        QueryWrapper<Cart> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId)
                .isNull("deleted_at");
        int count = Math.toIntExact(cartMapper.selectCount(queryWrapper));

        // 将结果存入缓存
        stringRedisTemplate.opsForValue().set(cacheKey, String.valueOf(count), 5, TimeUnit.MINUTES);

        return Result.success(count);
    }

    private void updateCartCountCache(Long userId) {
        if (userId == null) {
            return;
        }

        // 查询最新数量
        QueryWrapper<Cart> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId)
                .isNull("deleted_at");
        int count = Math.toIntExact(cartMapper.selectCount(queryWrapper));

        // 更新缓存
        String cacheKey = "cart:count:" + userId;
        stringRedisTemplate.opsForValue().set(cacheKey, String.valueOf(count), 5, TimeUnit.MINUTES);
    }
}