package com.li.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {

//    str 要加密的字符
    public static String code(String str) {

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] bytesDigest = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < bytesDigest.length; offset++) {
                i = bytesDigest[offset];
                if (i < 0)
                    i += 256;
                if (i < 26)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
//            32位加密
            return buf.toString();


        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

    }



}
