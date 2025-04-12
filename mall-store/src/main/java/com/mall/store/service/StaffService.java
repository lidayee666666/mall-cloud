package com.mall.store.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.api.domain.entity.Staff;
import com.mall.store.pojo.dto.StaffAddDTO;

public interface StaffService extends IService<Staff> {
    Staff getByUserId();

    Staff getByUserId(Long id);

    void addStaff(Long storeId, StaffAddDTO dto);
}
