package com.mall.store.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mall.common.utils.UserContext;
import com.mall.store.mapper.StaffMapper;
import com.mall.api.domain.entity.Staff;
import com.mall.store.pojo.dto.StaffAddDTO;
import com.mall.store.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff> implements StaffService {

    @Autowired
    StaffMapper staffMapper;

    @Override
    public Staff getByUserId() {
        Long userId = UserContext.getUser();
        LambdaQueryWrapper<Staff> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Staff::getUserId, userId);
        return getOne(queryWrapper);
    }

    @Override
    public Staff getByUserId(Long id) {
        LambdaQueryWrapper<Staff> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Staff::getUserId, id);
        return getOne(queryWrapper);
    }

    @Override
    public void addStaff(Long storeId, StaffAddDTO dto) {
        Staff staff = BeanUtil.toBean(dto, Staff.class);
        staff.setStoreId(storeId);
        staffMapper.insert(staff);
    }


}
