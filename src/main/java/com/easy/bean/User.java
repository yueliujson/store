package com.easy.bean;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 用户信息
 */
@Data
public class User {
    /**主键*/
    private Integer user_id;
    /**姓名*/
    private String name;
    /**性别*/
    private Integer sex;
    /**电话*/
    private String phone;
    /**用户名*/
    private String username;
    /**密码*/
    private String userpass;
    /**状态*/
    private Byte state;
    /**是否删除*/
    private Byte isDel;
    /**创建时间*/
    private Timestamp createTime;
    /**最后登录时间*/
    private Timestamp lastLoginTime;
}
