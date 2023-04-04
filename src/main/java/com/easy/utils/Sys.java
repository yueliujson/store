package com.easy.utils;

import java.io.File;

public class Sys {
    //登录名
    public static final String LOGIN_NAME="$LOGIN_NAME$";
    private static String path;
    static{
        File file=new File("");
        path = file.getAbsolutePath()+"\\src\\main\\webapp\\static\\img\\";
    }
    //图片文件路径
    public static final String IMAGES_PATH=path;
}
