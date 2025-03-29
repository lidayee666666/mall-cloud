package com.mall.payment.controller;


import com.mall.common.result.Result;
import com.mall.payment.pojo.Payment;
import com.mall.payment.pojo.dto.PaymentDTO;
import com.mall.payment.pojo.vo.PaymentVO;
import com.mall.payment.service.PaymentService;
import com.mall.payment.service.impl.PaymentServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;


@Api(tags = "商品下单接口")
@RestController
@RequestMapping("/payments/api")
@Slf4j
public class PayController {
    @Autowired
    private PaymentService payService;


    @ApiOperation("支付")
    @PostMapping("/pay")
    public Result<PaymentVO> pay(@RequestBody PaymentDTO paymentDTO) {
        log.info("创建支付订单，商品IDs: {}, 金额: {}",
                paymentDTO.getCartIds(),
                paymentDTO.getTotalAmount());
        try {
            //支付成功
            Result<PaymentVO> result=payService.pay(paymentDTO);
            return Result.success(result.getData());
        } catch (Exception e) {
            log.error("支付处理异常", e);
            return Result.error("支付处理失败");
        }
        }

}
