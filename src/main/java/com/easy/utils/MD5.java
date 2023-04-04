package com.easy.utils;

import org.apache.commons.codec.digest.DigestUtils;
//MD5加密
public class MD5 {
    public static String MD5Hex(String password) {
        for (int i = 0; i < 20; i++) {
            password = DigestUtils.md5Hex(password);
        }
        String pass = password;
        pass = 'a' + pass.substring(0, pass.length() / 2) + 'b' + pass.substring(pass.length() / 2 + 1);
        return pass;
    }


//对比密码是否相等
//@param newPass 新密码
//@param oldPass 数据库中的旧密码

    public static boolean equals(String newPass, String oldPass) {
        return  MD5Hex(newPass).equals(oldPass);
    }
}
