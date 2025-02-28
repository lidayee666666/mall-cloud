package com.mall.product.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mall.api.client.StoreClient;
import com.mall.api.domain.entity.Staff;
import com.mall.common.constant.MessageConstant;
import com.mall.common.constant.ProductStatusConstant;
import com.mall.common.exception.ProductStatusException;
import com.mall.common.exception.UserPermissionException;
import com.mall.common.result.Result;
import com.mall.product.mapper.ProductMapper;
import com.mall.product.pojo.dto.ProductDTO;
import com.mall.product.pojo.entity.Product;
import com.mall.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Autowired
    private StoreClient storeClient;

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
        // 对没有下架的商品也不能删除
        if(!Objects.equals(product.getStatus(), ProductStatusConstant.REMOVE)) {
            throw new ProductStatusException(MessageConstant.PRODUCT_STATUS_ERROR);
        }
        LambdaUpdateWrapper<Product> wrapper = new LambdaUpdateWrapper<>();
        wrapper.set(Product::getStatus, ProductStatusConstant.DELETE)
                .eq(Product::getId, id);
        update(wrapper);
    }

    @Override
    public void updateProduct(ProductDTO productDTO) {
        Long storeId = productDTO.getStoreId();
        boolean checked = checkRole(storeId);
        if(!checked) {
            throw new UserPermissionException(MessageConstant.USER_PERMISSION_ERROR);
        }
        Product product = BeanUtil.copyProperties(productDTO, Product.class);
        updateById(product);
    }

    private boolean checkRole(Long storeId) {
        // 使用feign调用商家服务，在员工表查询当前账号身份，获取其所属商家
        Result<Staff> result = storeClient.getByUserId();
        // 与当前商家比对，如果不一致或当前用户非员工则返回false
        Staff staff = result.getData();
        if(staff == null) {
            return false;
        }
        return staff.getStoreId().equals(storeId);
    }
}
