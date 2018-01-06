package tools;


import sun.misc.BASE64Encoder;

import javax.management.relation.Role;
import javax.management.relation.RoleNotFoundException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

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

    public static HashMap<String,String> A215StrToMap(String string){
        if (string == null)
            return  null;
        HashMap<String, String> a215Map = new HashMap<>();
        String[] str1 = string.split(";");
        for (String string1 : str1) {
            string1 = string1.trim();
            String[] str2 = string1.split(":");
            if (str2.length==2)
            a215Map.put(str2[0], str2[1]);
        }
        return a215Map;
    }
    public static String A215MapToStr(HashMap<String, String> map){
        StringBuilder stringBuilder = new StringBuilder();
        for(Map.Entry<String, String> entry:map.entrySet()){
            stringBuilder.append(entry.getKey());
            stringBuilder.append(":");
            stringBuilder.append(entry.getValue());
            stringBuilder.append(";");
        }
        return stringBuilder.toString();
    }

}

