import bean.main.A10;
import bean.register.A20;
import service.serviceIMP;
import tools.StringTools;

import java.util.ArrayList;
import java.util.Iterator;

public class servicetest {
    public static void main(String[] args) {
//        String test = null;
//        try{
//            test = StringTools.EncoderByMd5("123456");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        System.out.println(test);

        ArrayList<A20> a20ArrayList = new ArrayList<>();
        service.serviceIMP serviceIMP = new serviceIMP();
        A20 a20 = serviceIMP.FindPatient(21);
        System.out.println(a20.toString());
//        serviceIMP.DeleteStaff(1);
//        ArrayList<A20> a20 = serviceIMP.FindPatients(null,"1");
//        Iterator<A20> a20Iterator = a20.iterator();
//        while(a20Iterator.hasNext()){
//            System.out.println(a20Iterator.next().toString());
        }
        //≤‚ ‘
//        System.out.println(a20.toString());
    }
