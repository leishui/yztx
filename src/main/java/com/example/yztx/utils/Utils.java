package com.example.yztx.utils;

public class Utils {
    public static String generateVerificationCode() {
        return String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
    }

    public static Long getTimeStamp(){
        return System.currentTimeMillis()/1000;
    }
}
