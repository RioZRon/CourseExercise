package service;

import bean.main.A10;
import bean.register.A20;

import java.util.ArrayList;

public interface serviceForRegistration {

    /**
    * @Description: ��Ӳ���A20
    **/
    void addPatientBasicInformation (A20 a20);

    /**
    * @Description: ��������(ģ��)
    **/
    ArrayList<A20> FindPatients(String name, String id);

    /**
     * @Description: ��������(��׼)
     **/
    A20 FindPatient (int id);
}
