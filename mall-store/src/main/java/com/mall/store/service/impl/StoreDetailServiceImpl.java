package com.mall.store.service.impl;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mall.api.client.UserClient;
import com.mall.store.mapper.StoreDetailMapper;
import com.mall.store.pojo.dto.StoreUpdateDTO;
import com.mall.store.pojo.entity.StoreDetail;
import com.mall.store.pojo.vo.StoreDetailVO;
import com.mall.store.service.StoreDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreDetailServiceImpl extends ServiceImpl<StoreDetailMapper, StoreDetail> implements StoreDetailService {

    @Autowired
    private UserClient userClient;

    @Autowired
    private StoreDetailMapper mapper;

    @Override
    public void updateStoreInfo(Long storeId, StoreUpdateDTO dto) {
        StoreDetail bean = BeanUtil.toBean(dto, StoreDetail.class);
        bean.setStoreId(storeId);
        mapper.updateById(bean);
    }

    @Override
    public StoreDetailVO getStoreDetail(Long storeId) {
        List<StoreDetail> list = lambdaQuery().eq(StoreDetail::getStoreId, storeId).list();
        return BeanUtil.toBean(list.get(0), StoreDetailVO.class);
    }
}
