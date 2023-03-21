package com.easy.bean;

import com.easy.utils.TimeFormat;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 用户信息
 */
public class User {
    /**主键*/
    private Integer user_id;
    /**姓名*/
    private String name;
    /**性别*/
    private Integer sex;
    /**电话*/
    private String phone;
    /**邮箱*/
    private String email;
    /**用户名*/
    private String username;
    /**密码*/
    private String userpass;
    /**确认密码*/
    private String newPass;

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }

    public User(Integer user_id, String name, Integer sex, String phone, String email, String username, String userpass, String newPass, Byte state, Byte isDel, Timestamp createTime, Timestamp lastLoginTime) {
        this.user_id = user_id;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.userpass = userpass;
        this.newPass = newPass;
        this.state = state;
        this.isDel = isDel;
        this.createTime = createTime;
        this.lastLoginTime = lastLoginTime;
    }

    /**状态*/
    private Byte state;
    /**是否删除*/
    private Byte isDel;
    /**创建时间*/
    private Timestamp createTime;
    /**最后登录时间*/
    private Timestamp lastLoginTime;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User() {
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
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


    public String getLastLoginTime() {
        return TimeFormat.getTime(lastLoginTime);
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
