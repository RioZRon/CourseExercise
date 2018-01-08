package service;

import bean.main.A10;
import bean.medicine.A60;
import bean.medicine.A62;

import java.util.ArrayList;

public interface serviceForMedicine {
    /**
    * @Description: �������A60��
    **/
    ArrayList<A60> UpdateAndSelectAlertA60();

    /**
    * @Description: ��ʾҩƷ����
    **/
    A60 SelectMedicinDetail(int a601);

    /**
    * @Description: ��������ˮ
    **/
    void AddFlowIn(A62 a62);

    /**
    * @Description: ����ύ���޸Ķ�Ӧ��RemainNum
    **/
    void UpdateRemainNumByA62(A62 a62);

    /**
     * @Description: ����ҩƷ����idģ����ѯ
     **/
    ArrayList<A60> FindMedicines(String name, String id);

   /**
   * @Description: ����ҩƷ������Ϣ
   **/
    void UpdateMedicine(A60 a60);

    /**
    * @Description: ���ҩƷ������Ϣ
    **/
    int AddMedicineAndReturna601(A60 a60);
}
