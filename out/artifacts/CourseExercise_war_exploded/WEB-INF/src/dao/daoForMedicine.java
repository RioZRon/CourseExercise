package dao;

import bean.main.A10;
import bean.medicine.A60;
import bean.medicine.A62;
import bean.medicine.A63;

import java.sql.Connection;
import java.util.ArrayList;

public interface daoForMedicine {
    /**
     * @Description: 所有药瓶药品
     **/
    ArrayList<A60> SelectAllA60(Connection connection);

    /**
    * @Description: 用a607更新A60
    **/
    void UpdateA60Bya607 (Connection connection, int a601, String a607);

   /**
   * @Description: 根据A601 搜索A60
   **/
    A60 SelectA60ByA601(Connection connection, int a601);

   /**
   * @Description: 添加A62流水表
   **/
    void A62insert(Connection connection, A62 a62);

    /**
     * @Description: 添加A63流水表
     **/
    void A63insert(Connection connection, A63 a63);
    /**
    * @Description: 修改A60的A607
    **/
    void Updatea607Bya601(Connection connection, int A601, String A607);

    /**
    * @Description: 根据601602模糊查询60表
    **/
    ArrayList<A60> SelectA60Bya601a602inDark(Connection connection, String A602, String A601);

    /**
     * @Description: 更新A60
     **/
    void UpdateA60(Connection connection, A60 a60);

    /**
    * @Description: 添加A60
    **/
    void A60insert(Connection connection, A60 a60);

    /**
    * @Description: 根据唯一名 查询编号
    **/
    int Selecta601Bya602(Connection connection, String a602);

    /**
     * @Description: 根据id 查询
     **/
    String Selecta217Bya211(Connection connection, int a211);

    /**
    * @Description: 根据A602的范围搜索得到A60集合
    **/
    ArrayList<A60> SelectA60sBya602(Connection connection, String limitScope);

    /**
    * @Description: 根据601搜索最近一次进价
    **/
    int Selecta627Bya601(Connection connection, int a601);

    /**
    * @Description:根据a211修改a217
    **/
    void Updatea217Bya211(Connection connection,int a211, String a217);
}
