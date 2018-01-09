package dao;

import bean.main.A10;

import java.sql.Connection;

public interface daoForMain {
    /**
     * @Description: 取出登录得到的用户bean
     **/
    A10 SelectA10ByA103A104(Connection connection, String name, String pass);

    /**
    * @Description:
    **/
    void A20insertBya202a207a204(Connection connection,String a202, String a207, String a204);
}
