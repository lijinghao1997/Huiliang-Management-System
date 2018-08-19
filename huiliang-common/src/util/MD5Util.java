package util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
    private static MessageDigest messageDigest;
    static {
        try {
            messageDigest=MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

        }
    }
    public static String encrypt(String str){
        try {
            byte[] bytes=str.getBytes("UTF-8");
            messageDigest.update(bytes);
            byte[] newStr=messageDigest.digest();
            return new String(newStr);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
