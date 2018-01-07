import bean.medicine.RemainNum;
import tools.StringTools;

import java.util.HashMap;
import java.util.Map;

public class stringToolTest {
    public static void main(String[] args) {
//        String test = "CT:胸肺正常没有异样; 胸透:正常; 痰检:正常";

//        String Remain = "2018-11-1 | 10:6, 15:50, 50:10";
        String Remain = "2017-1-1|418:60,500:177,700:100";
        RemainNum remainNum = StringTools.StringToRemainNum(Remain);
        System.out.println(StringTools.RemainNumToString(remainNum));
//        System.out.print(remainNum.toString());
//        System.out.print(remainNum.getTreeMap().toString());
//        System.out.println(remainNum.toString()k);
//        Map<String, String> map = StringTools.A215StrToMap(test);
//        if(map == null){
//            System.out.println("-----ceshi1-------");
//        }
//        for(Map.Entry<String,String> entry : map.entrySet()){
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//        }
//
//        System.out.println(StringTools.A215MapToStr((HashMap)map));

    }

}