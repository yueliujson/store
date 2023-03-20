package com.easy.bean;

import com.easy.utils.TimeFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * 订单信息
 */
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
    /**详情*/
    private List<OrderFormDir> orderFormDirs;

    @Override
    public String toString() {
        return "OrderForm{" +
                "id=" + id +
                ", order_id='" + order_id + '\'' +
                ", user_id=" + user_id +
                ", money=" + money +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", receiver='" + receiver + '\'' +
                ", state=" + state +
                ", createTime=" + createTime +
                ", paymentTime=" + paymentTime +
                ", sendTime=" + sendTime +
                ", finishTime=" + finishTime +
                ", isDel=" + isDel +
                ", orderFormDirs=" + orderFormDirs +
                '}';
    }

    public List<OrderFormDir> getOrderFormDirs() {
        return orderFormDirs;
    }

    public void setOrderFormDirs(List<OrderFormDir> orderFormDirs) {
        this.orderFormDirs = orderFormDirs;
    }

    public OrderForm() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getCreateTime() {
        return TimeFormat.getTime(createTime);
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getPaymentTime() {
        return TimeFormat.getTime(paymentTime);
    }

    public void setPaymentTime(Timestamp paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getSendTime() {
        return TimeFormat.getTime(sendTime);
    }

    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }

    public String getFinishTime() {
        return TimeFormat.getTime(finishTime);
    }

    public void setFinishTime(Timestamp finishTime) {
        this.finishTime = finishTime;
    }

    public Byte getIsDel() {
        return isDel;
    }

    public void setIsDel(Byte isDel) {
        this.isDel = isDel;
    }

    public OrderForm(Integer id, String order_id, Integer user_id, BigDecimal money, String address, String phone, String receiver, Byte state, Timestamp createTime, Timestamp paymentTime, Timestamp sendTime, Timestamp finishTime, Byte isDel) {
        this.id = id;
        this.order_id = order_id;
        this.user_id = user_id;
        this.money = money;
        this.address = address;
        this.phone = phone;
        this.receiver = receiver;
        this.state = state;
        this.createTime = createTime;
        this.paymentTime = paymentTime;
        this.sendTime = sendTime;
        this.finishTime = finishTime;
        this.isDel = isDel;
    }
}
