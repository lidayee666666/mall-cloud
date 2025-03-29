package com.mall.payment.service;

import com.mall.common.result.Result;
import com.mall.payment.pojo.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {
    Result pay(PaymentDTO paymentDTO);

}
