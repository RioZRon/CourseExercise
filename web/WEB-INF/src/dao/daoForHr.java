package dao;

import bean.main.A10;

import java.sql.Connection;
import java.util.ArrayList;

public interface daoForHr {
    /**
     * @Description: ���A10
     **/
    void A10insert (Connection connection, A10 a10);

    /**
    * @Description: ͨ��a102 a103���� A10����
    **/
    ArrayList<A10> SelectA10Bya102a103inDark(Connection connection, String a102, String a103);

    /**
     * @Description: ͨ��a103���� A10
     **/
    A10 SelectA10Bya103(Connection connection, String a103);

    /**
    * @Description: ͨ��a101ɾ��A10
    **/
    void DeleteA10Bya101(Connection connection, int a101);

    /**
    * @Description: �޸�A10
    **/
    void UpdateA10(Connection connection, A10 a10);
}
