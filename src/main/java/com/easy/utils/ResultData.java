package com.easy.utils;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

//返回信息的集合
public class ResultData {
    //http的状态码
    private int code;
    //success fail
    private String message;
    //存数据的集合
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
