package com.ikkong.platform.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


    public class MD5utils {

        public static String getMd5(String str){
            MessageDigest md= null;
            try {
                md = MessageDigest.getInstance("MD5");
                md.update(str.getBytes());
                return new BigInteger(1,md.digest()).toString(16);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                return null;
            }
        }

        public static String getToken(String mobile){
            String str=new Long(System.currentTimeMillis()).toString()+mobile;
            str=getMd5(str);
            return str;
        }
//    public static void main(String args[]){
//        String test="test";
//        test=getMd5(test);
//        System.out.println(test);
//    }
    }


