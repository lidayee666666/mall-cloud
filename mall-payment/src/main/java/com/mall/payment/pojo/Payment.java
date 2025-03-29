package com.mall.payment.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("payment")
public class Payment {
    private Long id;
    private Long bizOrderNo;
    private Long payOrderNo;
    private Long bizUserId;
    private String payChannelCode;
    private String expandJson;
    private  String resultCode;
    private  String resultMsg;
    private  String responseJson;
    private Integer amount;
    private Integer payType;
    private Integer status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date  paySuccessTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date  payOverTime;
    private String qrCodeUrl;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date updateTime;
    private Long  creator;
    private Long updater;
    private Integer isDelete;
}
