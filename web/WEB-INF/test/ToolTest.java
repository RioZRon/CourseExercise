import bean.medicine.A60;
import bean.medicine.RemainNum;
import tools.OtherTools;
import tools.StringTools;

public class ToolTest {
    public static void main(String[] args) {
//        Date date1 = new Date();
//        int year = 0;
//        int month = 0;
//        int day = 0;
//        int bao =0;
//        while (true) {
//            Scanner in = new Scanner(System.in);
//            System.out.println("bao:");
//            bao = in.nextInt();
//            System.out.println("year:");
//            year = in.nextInt();
//            System.out.println("month:");
//            month = in.nextInt();
//            System.out.println("day:");
//            day = in.nextInt();
//            Date date2 = new Date(year-1900,month+1,day);
//            System.out.println(tools.OtherTools.DifferentDaysByMillisecond(date1,date2));
//            System.out.println("保质期剩余:");
//            System.out.println(bao-tools.OtherTools.DifferentDaysByMillisecond(date1,date2));
//        }

//        A60 testA60 = new A60(102,"栀子花金片",4,"2018-1-1|1:10,2:3,4:30", 10);
//        System.out.println(testA60.toString());
//        testA60 = OtherTools.RemainNumUpdate(testA60);
//        System.out.println(testA60.toString());
//
//        String test = "";
//        int a = Integer.valueOf(test);
//        System.out.println(a);
        String test = "2018-01-05|10:10,";
        RemainNum  remainNum = StringTools.StringToRemainNum(test);
        System.out.println(remainNum.getDate());
        System.out.println(remainNum.getTreeMap());
    }
}
