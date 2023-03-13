package com.easy.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TimeFormat {
    public static String getTime(Timestamp timestamp){
        if (timestamp==null){
            return null;
        }
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format = simpleDateFormat.format(timestamp);
        return format;
    }
}
