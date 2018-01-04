package dao;

import bean.main.A10;

import java.sql.Connection;
import java.util.ArrayList;

public interface daoForHr {
    /**
     * @Description: 添加A10
     **/
    void A10insert (Connection connection, A10 a10);

    /**
    * @Description: 通过a102 a103搜索 A10集合
    **/
    ArrayList<A10> SelectA10Bya102a103inDark(Connection connection, String a102, String a103);

    /**
     * @Description: 通过a103搜索 A10
     **/
    A10 SelectA10Bya103(Connection connection, String a103);

    /**
    * @Description: 通过a101删除A10
    **/
    void DeleteA10Bya101(Connection connection, int a101);

    /**
    * @Description: 修改A10
    **/
    void UpdateA10(Connection connection, A10 a10);
}
