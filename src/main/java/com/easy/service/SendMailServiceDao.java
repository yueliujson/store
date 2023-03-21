package com.easy.service;

public interface SendMailServiceDao {
    String sendQQEmail(String recevices, String code, String name) throws Exception;
}
