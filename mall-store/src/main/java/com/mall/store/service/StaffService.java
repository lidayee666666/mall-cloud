package com.mall.store.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.api.domain.entity.Staff;

public interface StaffService extends IService<Staff> {
    Staff getByUserId();
}
