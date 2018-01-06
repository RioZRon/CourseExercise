package service;

import bean.main.A10;
import bean.outpatientdocter.A21;
import bean.register.A20;

import java.util.ArrayList;

public interface serviceForOutPatientDocter {
    /**
    * @Description: �õ�ҽ����Ӧ�Ŀ���
    **/
    int FindDoctorRoom(int id);

    /**
    * @Description: �������з��䵽������ҵĲ���
    **/
    ArrayList<A20> FindPatientsBya2010(int a2010);

    /**
    * @Description: ���ݹҺŲ�ѯ����
    **/
    A21 FindMedicalrecord(int a211);

    /**
    * @Description: ��Ӳ���(Ŀǰ��ӵĶ��ǿյ� ֻ�б�� ��Ϣȫ��update)
    **/
    void addEmptyFindMedicalrecord(A21 a21);

    /**
    * @Description: �޸�A21
    **/
    void UpdateMedicalrecord(A21 a21);
}
