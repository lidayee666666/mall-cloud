package com.mall.store.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.store.pojo.entity.Store;
import com.mall.store.pojo.entity.StoreDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StoreDetailMapper extends BaseMapper<StoreDetail> {
}
