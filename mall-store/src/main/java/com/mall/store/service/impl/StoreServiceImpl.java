package com.mall.store.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mall.api.client.UserClient;
import com.mall.api.domain.entity.SimpleStore;
import com.mall.api.domain.entity.User;
import com.mall.common.result.Result;
import com.mall.common.utils.UserContext;
import com.mall.store.mapper.StoreMapper;
import com.mall.store.pojo.entity.Store;
import com.mall.store.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class StoreServiceImpl extends ServiceImpl<StoreMapper, Store> implements StoreService {
    @Autowired
    StoreMapper storeMapper;
    @Autowired
    private UserClient userClient;

    @Override
    public SimpleStore getStoreNameById(Long id) {
        QueryWrapper<Store> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Store::getId, id)
                .select(Store::getId, Store::getName);
        Store store = storeMapper.selectOne(queryWrapper);
        if (store == null) {
            return null;
        }
        SimpleStore simpleStore = new SimpleStore();
        simpleStore.setId(store.getId());
        simpleStore.setName(store.getName());

        return simpleStore;
    }

    @Override
    public User checkStoreStaff() {
        Long id = UserContext.getUser();
        User user = userClient.getById(id);

        return user;
    }
}
