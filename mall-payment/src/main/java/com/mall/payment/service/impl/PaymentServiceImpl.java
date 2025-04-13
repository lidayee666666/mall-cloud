package com.mall.payment.service.impl;


import cn.hutool.core.bean.BeanUtil;
import com.mall.common.result.Result;
import com.mall.common.utils.UserContext;
import com.mall.payment.mapper.PaymentMapper;
import com.mall.payment.pojo.Payment;
import com.mall.payment.pojo.dto.PaymentDTO;
import com.mall.payment.pojo.vo.PaymentVO;
import com.mall.payment.service.PaymentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Random;


@Service
public class PaymentServiceImpl implements PaymentService {
    private static final Logger log = LoggerFactory.getLogger(PaymentServiceImpl.class);
    private static final Random random=new Random();
    @Autowired
    private PaymentMapper paymentMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

   @Transactional(rollbackFor = Exception.class)
    public Result<PaymentVO>  pay(PaymentDTO paymentDTO) {
        Payment payment= BeanUtil.toBean(paymentDTO,Payment.class);

        PaymentVO paymentVO=new PaymentVO();

        try {

            //设置支付信息
            payment.setPayOrderNo((long) (Math.random() * 900_000_000) + 100_000_000);
            payment.setPayChannelCode("0");

            payment.setBizUserId(UserContext.getUser());
            //payment.setAmount(paymentDTO.getAmount());
           // payment.setPayType(random.nextInt(7)+1);
            payment.setPayType(6); //支付宝
            payment.setCreator(UserContext.getUser());
            payment.setUpdater(UserContext.getUser());


            //支付成功
            payment.setStatus(2);

            //插入支付记录
            paymentMapper.insert(payment);

            //设置业务订单号（基于数据库生成的ID）
//            payment.setBizOrderNo(payment.getId());
//            paymentMapper.updateById(payment);

            paymentVO.setStatus(payment.getStatus());
            return Result.success(paymentVO);
        }catch (Exception e) {
            log.error("支付失败", e);
            payment.setStatus(0);
            paymentMapper.insert(payment);

            //设置业务订单号（基于数据库生成的ID）
            payment.setBizOrderNo(payment.getId());
            paymentMapper.updateById(payment);
            paymentVO.setStatus(payment.getStatus());
            return Result.error("支付失败");
        }
    }

}
