import bean.main.A10;
import service.serviceIMP;
import tools.StringTools;

import java.util.ArrayList;
import java.util.Iterator;

public class servicetest {
    public static void main(String[] args) {
        String test = null;
        try{
            test = StringTools.EncoderByMd5("123456");
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(test);

//        ArrayList<A10> a10ArrayList = new ArrayList<>();
//        service.serviceIMP serviceIMP = new serviceIMP();
////        serviceIMP.DeleteStaff(1);
//       A10 a10 = serviceIMP.FindStaff("riosysm");
//        //≤‚ ‘
//        System.out.println(a10.toString());
    }
}
