package service;

import bean.main.A10;
import bean.register.A20;

import java.util.ArrayList;

public interface serviceForRegistration {

    /**
    * @Description: 添加病人A20
    **/
    void addPatientBasicInformation (A20 a20);

    /**
    * @Description: 搜索病人(模糊)
    **/
    ArrayList<A20> FindPatients(String name, String id);

    /**
     * @Description: 搜索病人(精准)
     **/
    A20 FindPatient (int id);
}
