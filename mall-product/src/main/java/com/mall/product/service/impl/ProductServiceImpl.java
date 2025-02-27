package com.mall.product.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mall.common.constant.MessageConstant;
import com.mall.common.context.BaseContext;
import com.mall.common.exception.UserPermissionException;
import com.mall.product.mapper.ProductMapper;
import com.mall.product.pojo.dto.ProductDTO;
import com.mall.product.pojo.entity.Product;
import com.mall.product.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Override
    public void saveProduct(ProductDTO productDTO) {
        Long storeId = productDTO.getStoreId();
        boolean checked = checkRole(storeId);
        if(!checked) {
            throw new UserPermissionException(MessageConstant.USER_PERMISSION_ERROR);
        }
        // 进行新增操作
        Product product = BeanUtil.copyProperties(productDTO, Product.class);
        save(product);
    }

    @Override
    public void removeProduct(Long id) {
        Product product = getById(id);
        Long storeId = product.getStoreId();
        boolean checked = checkRole(storeId);
        if(!checked) {
            throw new UserPermissionException(MessageConstant.USER_PERMISSION_ERROR);
        }
        // TODO 对没有下架的商品也不能删除
        removeById(id);
    }

    @Override
    public void updateProduct(ProductDTO productDTO) {
        Long storeId = productDTO.getStoreId();
        boolean checked = checkRole(storeId);
        if(!checked) {
            throw new UserPermissionException(MessageConstant.USER_PERMISSION_ERROR);
        }
        // TODO 是否需要对商品的上架/下架状态先进行判断，然后再进行更新？
        Product product = BeanUtil.copyProperties(productDTO, Product.class);
        updateById(product);
    }

    private boolean checkRole(Long storeId) {
        Long userId = BaseContext.getCurrentId();
        // TODO 使用feign调用商家服务，在员工表查询当前账号身份，获取其所属商家

        // 与当前商家比对，如果不一致或当前用户非员工则返回false

        return true;
    }
}
