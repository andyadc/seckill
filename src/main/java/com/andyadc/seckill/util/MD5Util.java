package com.andyadc.seckill.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author andaicheng
 * @since 2018/9/2
 */
public class MD5Util {

    private static final String FIXED_SALT = "1qaz2wsx3edc";

    public static void main(String[] args) {
        System.out.println(inputPassToDbPass("123456", "qwerty"));
    }

    public static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }

    public static String inputPassToFormPass(String inputPass) {
        String str = "" + FIXED_SALT.charAt(0) + FIXED_SALT.charAt(2) + inputPass + FIXED_SALT.charAt(5) + FIXED_SALT.charAt(4);
        return md5(str);
    }

    public static String formPassToDBPass(String formPass, String salt) {
        String str = "" + salt.charAt(0) + salt.charAt(2) + formPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    public static String inputPassToDbPass(String inputPass, String saltDB) {
        String formPass = inputPassToFormPass(inputPass);
        String dbPass = formPassToDBPass(formPass, saltDB);
        return dbPass;
    }
}
