package com.example.yztx.utils;

public class Utils {
    public static String generateVerificationCode(){
        return String.valueOf((int)((Math.random()*9+1)*100000));
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(generateVerificationCode());
        }
    }
}
