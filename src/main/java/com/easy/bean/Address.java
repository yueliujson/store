package com.easy.bean;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 地址信息
 */
@Data
public class Address {
    /**主键*/
    private Integer id;
    /**用户id*/
    private Integer user_id;
    /**省*/
    private String province;
    /**市*/
    private String city;
    /**区*/
    private String area;
    /**详细地址*/
    private String address;
    /**电话*/
    private String phone;
    /**收货人*/
    private String receiver;
    /**状态 0默认地址*/
    private Byte state;
    /**是否删除*/
    private Byte isDel;
    /**创建创建时间*/
    private Timestamp createTime;
    /**最后一次修改时间*/
    private Timestamp lastEditTime;
}
