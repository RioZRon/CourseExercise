package tools;


import sun.misc.BASE64Encoder;

import javax.management.relation.Role;
import javax.management.relation.RoleNotFoundException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringTools {
    public static String emptyToNull(String str){
        if (str.equals(""))
            return null;
        else return str;
    }
    public static String nullToEmpty(String str){
        if(str == null)
            str = "";
        return str;
    }
    public static String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }
    public static String RoleTraslate(int roleNum){
            if (roleNum == 1)
                return "挂号";
            else if(roleNum == 2)
                return "门诊";
            else if(roleNum == 3)
                return "病房";
            else if(roleNum == 4)
                return "手术";
            else if(roleNum == 5)
                return "管理员";
            else
                throw new RuntimeException("RoleNotFound");
        }
    }

