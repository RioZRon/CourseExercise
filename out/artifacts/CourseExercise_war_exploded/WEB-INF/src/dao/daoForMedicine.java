package dao;

import bean.main.A10;
import bean.medicine.A60;
import bean.medicine.A62;

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
    * @Description: 修改A60的A607
    **/
    void Updatea607Bya601(Connection connection, int A601, String A607);
}
