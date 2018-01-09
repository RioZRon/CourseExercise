import bean.main.A10;
import bean.medicine.A60;
import bean.outpatientdocter.A21;
import bean.register.A20;
import service.serviceIMP;
import tools.StringTools;

import java.util.ArrayList;
import java.util.Iterator;

public class servicetest {
    public static void main(String[] args) {
//        String test = null;
//        try {
//            test = StringTools.EncoderByMd5("123456");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        String name = "×Ý½ðºê";
        String identityCard= "50022219970126661X";
        String phoneNumber = "15554240869";

        service.serviceIMP serviceIMP = new serviceIMP();
        serviceIMP.addBookingPatientBasicInformation(name, identityCard, phoneNumber);
//        A21 a21 = new A21(21, "1","1","1","1","1","1","1","1");
//        serviceIMP.UpdateMedicalrecord(a21);
//        ArrayList<A60> rs = serviceIMP.UpdateAndSelectAlertA60();
//        for(A60 a60 : rs){
//            System.out.println(a60.toString());
//        }

//        ArrayList<A20> a20ArrayList = new ArrayList<>();
//        a20ArrayList = serviceIMP.FindPatientsBya2010(2);
//
//
////        A20 a20 = serviceIMP.FindPatient(21);
////        System.out.println(a20.toString());
//
////        serviceIMP.DeleteStaff(1);
////        ArrayList<A20> a20 = serviceIMP.FindPatients(null,"1");
//        Iterator<A20> a20Iterator = a20ArrayList.iterator();
//        while(a20Iterator.hasNext()) {
//            System.out.println(a20Iterator.next().toString());
//        }
//        }
        //²âÊÔ
//        System.out.println(a20.toString());
    }
}
