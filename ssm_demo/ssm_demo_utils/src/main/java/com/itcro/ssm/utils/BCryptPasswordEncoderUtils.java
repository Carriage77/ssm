package com.itcro.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    public static String encodePassword(String password){return bCryptPasswordEncoder.encode(password);}


    public static void main(String[] args) {
        String password="88888888";
        String pwd = encodePassword(password);
        //$2a$10$pHJ2CGnR9WEVJbEefu/GNujfIyCfwRKLI2QIyZc5EVRra/W6bFIGq
        System.out.println(pwd);
    }


}
