package tools;


import bean.medicine.RemainNum;
import sun.misc.BASE64Encoder;

import javax.management.relation.Role;
import javax.management.relation.RoleNotFoundException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class StringTools {
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
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
                return "医药";
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

    public static RemainNum StringToRemainNum (String string){
        RemainNum remainNum = null;
        if (string == null  || string.isEmpty()){
            return null;
        }
        String[] str1 = string.split("\\|");
//        System.out.println(str1[0].trim());
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        String[] str2 = str1[1].split(",");
        for(String string2 : str2){
            string2 = string2.trim();
            String[] str3 = string2.split(":");
            if (str3.length==2)
                try{
                    treeMap.put(Integer.valueOf(str3[0].trim()),Integer.valueOf(str3[1].trim()));
//                    System.out.println(treeMap);
                }catch(NumberFormatException e){
                    System.out.println("ReamainNumber存储方式出错");
                }
        }
        try {
            Date date =simpleDateFormat.parse(str1[0].trim());
//            System.out.println(date);
            remainNum = new RemainNum(date, treeMap);
        }catch(ParseException t){
            t.getErrorOffset();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        return remainNum;
    }
    public static String RemainNumToString(RemainNum remainNum){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(simpleDateFormat.format(remainNum.getDate()));
        stringBuffer.append("|");
        for (Map.Entry<Integer,Integer> entry : remainNum.getTreeMap().entrySet())
        {
            stringBuffer.append(entry.getKey());
            stringBuffer.append(":");
            stringBuffer.append(entry.getValue());
            stringBuffer.append(",");
        }
        return stringBuffer.toString();
    }

    public static TreeMap<String, Integer> PrescriptionStringToMap(String string){
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        String[] str1 = string.split(",");
        for(String string1 : str1){
            string1 = string1.trim();
//            System.out.println(string1);
            String[] str2 = string1.split("\\*");
            if (str2.length==2)
                try{
                    treeMap.put(str2[0].trim(),Integer.valueOf(str2[1].trim()));
//                    System.out.println(treeMap);
                }catch(NumberFormatException e){
                    System.out.println("ReamainNumber存储方式出错");
                }
        }
        return treeMap;
    }

    public static  String PrescriptionMapToString(TreeMap<String, Integer> treeMap){
        boolean first = true;
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()){
            if (!first){
                stringBuffer.append(",");
            }
            stringBuffer.append(entry.getKey());
            stringBuffer.append("*");
            stringBuffer.append(entry.getValue());
            first = false;
        }
        return stringBuffer.toString();
    }
}

