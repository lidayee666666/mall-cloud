package com.mall.store.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.api.domain.entity.SimpleStore;
import com.mall.api.domain.entity.User;
import com.mall.store.pojo.dto.StoreUpdateDTO;
import com.mall.store.pojo.entity.Store;
import com.mall.store.pojo.entity.StoreDetail;
import com.mall.store.pojo.vo.StoreDetailVO;

public interface StoreDetailService extends IService<StoreDetail> {


    void updateStoreInfo(Long storeId, StoreUpdateDTO dto);

    StoreDetailVO getStoreDetail(Long storeId);
}
