package com.easy.utils;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回信息
 */
public class ResultData {
    /**Http状态码*/
    private int code;
    /**信息（是否成功）*/
    private String message;
    /**数据*/
    private Map data=new HashMap();

    public void put(String key,Object value){
        data.put(key,value);
    }

    public ResultData() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map getData() {
        return data;
    }

    public void setData(Map data) {
        this.data = data;
    }

    public ResultData(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
