package com.easy.bean;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 订单信息
 */
@Data
public class OrderForm {
    /**主键*/
    private Integer id;
    /**订单号*/
    private String order_id;
    /**用户id*/
    private Integer user_id;
    /**支付金额*/
    private BigDecimal money;
    /**地址*/
    private String address;
    /**电话*/
    private String phone;
    /**收货人*/
    private String receiver;
    /**状态*/
    private Byte state;
    /**创建时间*/
    private Timestamp createTime;
    /**支付时间*/
    private Timestamp paymentTime;
    /**发货时间*/
    private Timestamp sendTime;
    /**完成时间*/
    private Timestamp finishTime;
    /**是否删除*/
    private Byte isDel;
}
