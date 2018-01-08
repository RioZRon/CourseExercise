package service;

import bean.main.A10;
import bean.medicine.A60;
import bean.medicine.A62;
import bean.medicine.A63;

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
    * @Description:��ӳ�����ˮ
    **/
    void AddFlowOut(A63 a63);


    /**
    * @Description: ����ύ���޸Ķ�Ӧ��RemainNum
    **/
    void UpdateRemainNumByA62(A62 a62);
    /**
     * @Description: �����ύ���޸Ķ�Ӧ��RemainNum
     **/
    void UpdateRemainNumByA63(A63 a63);
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

    /**
    * @Description: ����id����A21���A214
    **/
    String SelectMedicineNeeded(int a201);

    /**
    * @Description: ��ʾ���еĶ�Ӧҩ��
    **/
    ArrayList<A60> ShowAllNeededMedicine(String a217);

    /**
    * @Description: ��������
    **/
    int SelectInprice(int a601);

    /**
    * @Description: ����217����
    **/
    void UpdatePrescrpe(int a201,String new217);

}
