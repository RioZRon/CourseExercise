package service;

import bean.main.A10;
import dao.daoIMP;
import tools.JDBCPool;
import tools.JDBCPoolTools;

import java.sql.Connection;

public class serviceIMP implements serviceForMain, serviceForHr{
    /**
     * @param name
     * @param pass
     * @Description: 取出登录得到的用户bean
     */
    @Override
    public A10 SignIn(String name, String pass) {
        Connection connection = JDBCPoolTools.getConnection();
        daoIMP daoImp = new daoIMP();
        A10 a10= daoImp.SelectA10ByA103A104(connection, name, pass);
        return a10;
    }

    /**
     * @param a10
     * @Description: 添加用户信息
     */
    @Override
    public void AddStaff(A10 a10) {
        Connection connection = JDBCPoolTools.getConnection();
        daoIMP daoIMP = new daoIMP();
        daoIMP.A10insert(connection, a10);
    }
}
