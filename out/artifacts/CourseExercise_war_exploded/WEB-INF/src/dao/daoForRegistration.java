package dao;

import bean.main.A10;
import bean.register.A20;

import java.sql.Connection;
import java.util.ArrayList;

public interface daoForRegistration {
    /**
     * @Description: ���A20
     **/
    void A20insert(Connection connection, A20 a20);

    /**
    * @Description: ����a201a202����A20
    **/
    ArrayList<A20> SelectA20Bya201a202inDark(Connection connection,String a202, String a201);

    /**
    * @Description: ����201����A20
    **/
    A20 SelectA20Bya201(Connection connection, int a201);
}
