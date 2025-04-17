package com.mall.payment.controller;

/**
 * @author 李青龙
 * @date 2025/04/12 19:48
 * 功能描述:
 */

import com.alipay.easysdk.factory.Factory;
import com.mall.api.client.OrderClient;
import com.mall.payment.config.AliPayConfig;
import com.mall.payment.pojo.dto.PaymentDTO;
import com.mall.payment.pojo.entity.AliPay;
import com.mall.payment.pojo.vo.PaymentVO;
import com.mall.payment.service.PaymentService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/alipay")
@Transactional(rollbackFor = Exception.class)
public class AliPayController {

    @Autowired
    OrderClient orderClient;

    @Resource
    AliPayConfig aliPayConfig;

    @Autowired
    private PaymentService paymentService;

    private static final String GATEWAY_URL = "https://openapi-sandbox.dl.alipaydev.com/gateway.do";
    private static final String FORMAT = "JSON";
    private static final String CHARSET = "utf-8";
    private static final String SIGN_TYPE = "RSA2";

    @RequestMapping("/pay") // &subject=xxx&traceNo=xxx&totalAmount=xxx
    public void pay(AliPay aliPay, HttpServletResponse httpResponse) throws Exception {

        AlipayClient alipayClient = new DefaultAlipayClient(GATEWAY_URL, aliPayConfig.getAppId(),
                aliPayConfig.getAppPrivateKey(), FORMAT, CHARSET, aliPayConfig.getAlipayPublicKey(), SIGN_TYPE);
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        request.setNotifyUrl(aliPayConfig.getNotifyUrl());
        request.setBizContent("{\"out_trade_no\":\"" + aliPay.getTradeNo() + "\","
                + "\"total_amount\":\"" + aliPay.getTotalAmount() + "\","
                + "\"subject\":\"" + aliPay.getSubject() + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        String form = "";
        try {
            // 调用SDK生成表单
            form = alipayClient.pageExecute(request).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + CHARSET);
        // 直接将完整的表单html输出到页面
        httpResponse.getWriter().write(form);
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }


//    @PostMapping("/notify")  // 注意这里必须是POST接口
//    public String payNotify(HttpServletRequest request) throws Exception {
//
//        if (request.getParameter("trade_status").equals("TRADE_SUCCESS")) {
//            System.out.println("=========支付宝异步回调========");
//
//            Map<String, String> params = new HashMap<>();
//            Map<String, String[]> requestParams = request.getParameterMap();
//
//            for (String name : requestParams.keySet()) {
//                params.put(name, request.getParameter(name));
//                // System.out.println(name + " = " + request.getParameter(name));
//            }
//
//
//            //商户订单号
//            String tradeNo = params.get("out_trade_no");
//            //买家付款时间
//            String gmtPayment = params.get("gmt_payment");
//            //支付宝交易凭证号
//            String alipayTradeNo = params.get("trade_no");
//
//
//            // 支付宝验签
//            if (Factory.Payment.Common().verifyNotify(params)) {
//                // 验签通过
//                System.out.println("交易名称: " + params.get("subject"));
//                System.out.println("交易状态: " + params.get("trade_status"));
//                System.out.println("支付宝交易凭证号: " + params.get("trade_no"));
//                System.out.println("商户订单号: " + params.get("out_trade_no"));
//                System.out.println("交易金额: " + params.get("total_amount"));
//                System.out.println("买家在支付宝唯一id: " + params.get("buyer_id"));
//                System.out.println("买家付款时间: " + params.get("gmt_payment"));
//                System.out.println("买家付款金额: " + params.get("buyer_pay_amount"));
//
//                // 更新订单未已支付
////                Orders order = new Orders();
////                order.setId(Long.valueOf(tradeNo));
////                order.setStatus(2);
////                shopOrderMapper.updateById(order);
//            }
//        }
//        return "success";
//    }

    @RequestMapping("/notify")
    public String notify(HttpServletRequest request) {
        Map<String, String> params = convertParams(request);
        log.info("支付宝回调参数: {}", params); // 记录完整参数

        try {
            // 1. 验签
//            if (!Factory.Payment.Common().verifyNotify(params)) {
//                log.warn("支付宝验签失败");
//                return "failure";
//            }

            // 2. 处理交易成功逻辑
            if ("TRADE_SUCCESS".equals(params.get("trade_status"))) {
                String tradeNo = params.get("trade_no"); // 支付宝交易号
                String outTradeNo = params.get("out_trade_no"); // 商户订单号

                // 2.1 更新订单状态
                orderClient.consign(Long.valueOf(outTradeNo));

                // 2.2 记录支付信息
                PaymentDTO paymentDTO = new PaymentDTO();

                paymentDTO.setBizOrderNo(Long.valueOf(outTradeNo));
                paymentDTO.setAmount((int) (Double.parseDouble(params.get("total_amount")) * 100));

                // 定义时间格式
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

                // 获取时间字符串
                String gmtPayment = params.get("gmt_payment");

                // 解析为 LocalDateTime
                LocalDateTime localDateTime = LocalDateTime.parse(gmtPayment, formatter);

                // 将 LocalDateTime 转换为 Date
                Date payTime = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

                paymentDTO.setPaySuccessTime(payTime);
                paymentDTO.setBizUserId(Long.valueOf(params.get("buyer_id"))); // 支付宝返回的买家ID);
                paymentService.pay(paymentDTO);

                log.info("支付成功处理完成 - 订单: {}", outTradeNo);
            }
            return "success";
        } catch (Exception e) {
            log.error("支付宝回调处理异常", e);
            return "failure";
        }
    }

    private Map<String, String> convertParams(HttpServletRequest request) {
        Map<String, String[]> requestParams = request.getParameterMap();
        Map<String, String> params = new HashMap<>();

        for (String name : requestParams.keySet()) {
            params.put(name, request.getParameter(name));
        }
        return params;
    }
}
