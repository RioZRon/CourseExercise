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
        //ȷ�����㷽��
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //���ܺ���ַ���
        String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }
    public static String RoleTraslate(int roleNum){
            if (roleNum == 1)
                return "�Һ�";
            else if(roleNum == 2)
                return "����";
            else if(roleNum == 3)
                return "����";
            else if(roleNum == 4)
                return "����";
            else if(roleNum == 5)
                return "����Ա";
            else
                throw new RuntimeException("RoleNotFound");
        }
    }
