package dao;

import bean.main.A10;
import bean.medicine.A60;
import bean.medicine.A62;

import java.sql.Connection;
import java.util.ArrayList;

public interface daoForMedicine {
    /**
     * @Description: ����ҩƿҩƷ
     **/
    ArrayList<A60> SelectAllA60(Connection connection);

    /**
    * @Description: ��a607����A60
    **/
    void UpdateA60Bya607 (Connection connection, int a601, String a607);

   /**
   * @Description: ����A601 ����A60
   **/
    A60 SelectA60ByA601(Connection connection, int a601);

   /**
   * @Description: ����A62��ˮ��
   **/
    void A62insert(Connection connection, A62 a62);

    /**
    * @Description: �޸�A60��A607
    **/
    void Updatea607Bya601(Connection connection, int A601, String A607);

    /**
    * @Description: ����601602ģ����ѯ60��
    **/
    ArrayList<A60> SelectA60Bya601a602inDark(Connection connection, String A602, String A601);

    /**
     * @Description: ����A60
     **/
    void UpdateA60(Connection connection, A60 a60);

    /**
    * @Description: ����A60
    **/
    void A60insert(Connection connection, A60 a60);

    /**
    * @Description: ����Ψһ�� ��ѯ���
    **/
    int Selecta601Bya602(Connection connection, String a602);
}