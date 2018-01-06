package service;

import bean.main.A10;
import bean.outpatientdocter.A21;
import bean.register.A20;

import java.util.ArrayList;

public interface serviceForOutPatientDocter {
    /**
    * @Description: 得到医生对应的科室
    **/
    int FindDoctorRoom(int id);

    /**
    * @Description: 搜索所有分配到这个科室的病人
    **/
    ArrayList<A20> FindPatientsBya2010(int a2010);

    /**
    * @Description: 根据挂号查询病历
    **/
    A21 FindMedicalrecord(int a211);

    /**
    * @Description: 添加病历(目前添加的都是空的 只有标号 信息全靠update)
    **/
    void addEmptyFindMedicalrecord(A21 a21);

    /**
    * @Description: 修改A21
    **/
    void UpdateMedicalrecord(A21 a21);
}
