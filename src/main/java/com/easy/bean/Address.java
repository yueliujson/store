package com.easy.bean;

import com.easy.utils.TimeFormat;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;


//  地址信息

public class Address {
//    主键
    private Integer id;
//    用户id
    private Integer user_id;
//    省
    private String province;
//    市
    private String city;
//    区
    private String area;
//    详细地址
    private String address;
//    电话
    private String phone;
//    收货人
    private String receiver;
//    状态 0默认地址
    private Byte state;
//    是否删除
    private Byte isDel;
//    创建创建时间
    private Timestamp createTime;
//    最后一次修改时间
    private Timestamp lastEditTime;

    public Address() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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

    public Byte getIsDel() {
        return isDel;
    }

    public void setIsDel(Byte isDel) {
        this.isDel = isDel;
    }

    public String getCreateTime() {
        return TimeFormat.getTime(createTime);
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getLastEditTime() {
        return TimeFormat.getTime(lastEditTime);
    }

    public void setLastEditTime(Timestamp lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public Address(Integer id, Integer user_id, String province, String city, String area, String address, String phone, String receiver, Byte state, Byte isDel, Timestamp createTime, Timestamp lastEditTime) {
        this.id = id;
        this.user_id = user_id;
        this.province = province;
        this.city = city;
        this.area = area;
        this.address = address;
        this.phone = phone;
        this.receiver = receiver;
        this.state = state;
        this.isDel = isDel;
        this.createTime = createTime;
        this.lastEditTime = lastEditTime;
    }
}
