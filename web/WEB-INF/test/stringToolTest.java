import tools.StringTools;

import java.util.HashMap;
import java.util.Map;

public class stringToolTest {
    public static void main(String[] args) {
//        String test = "CT:�ط�����û������; ��͸:����; ̵��:����";
        String test = "test";
        Map<String, String> map = StringTools.A215StrToMap(test);
        if(map == null){
            System.out.println("-----ceshi1-------");
        }
//        for(Map.Entry<String,String> entry : map.entrySet()){
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//        }
//
//        System.out.println(StringTools.A215MapToStr((HashMap)map));

    }

}