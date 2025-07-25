package com.mall.store.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.api.domain.entity.SimpleStore;
import com.mall.api.domain.entity.User;
import com.mall.store.pojo.dto.StoreUpdateDTO;
import com.mall.store.pojo.entity.Store;

public interface StoreService extends IService<Store> {
    SimpleStore getStoreNameById(Long id);

    User checkStoreStaff();

}
