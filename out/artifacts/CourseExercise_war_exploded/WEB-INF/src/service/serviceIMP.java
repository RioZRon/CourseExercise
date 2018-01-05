package service;

import bean.main.A10;
import bean.register.A20;
import dao.daoIMP;
import tools.JDBCPool;
import tools.JDBCPoolTools;

import java.sql.Connection;
import java.util.ArrayList;

public class serviceIMP implements serviceForMain, serviceForHr, serviceForRegistration{
    /**
     * @param name
     * @param pass
     * @Description: ȡ����¼�õ����û�bean
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
     * @Description: ����û���Ϣ
     */
    @Override
    public void AddStaff(A10 a10) {
        Connection connection = JDBCPoolTools.getConnection();
        daoIMP daoIMP = new daoIMP();
        daoIMP.A10insert(connection, a10);
    }

    /**
     * @param name  û��Ϊnull
     * @param username  û�о�Ϊnull
     * @Description: �����û���Ϣ
     */
    @Override
    public ArrayList<A10> FindStaffs(String name, String username) {
        Connection connection = JDBCPoolTools.getConnection();
        daoIMP daoIMP = new daoIMP();
        ArrayList<A10> a10ArrayList = daoIMP.SelectA10Bya102a103inDark(connection,name,username);
        return  a10ArrayList;
    }

    /**
     * @param id
     * @Description: ɾ���û�
     */
    @Override
    public void DeleteStaff(int id) {
        Connection connection = JDBCPoolTools.getConnection();
        daoIMP daoIMP = new daoIMP();
        daoIMP.DeleteA10Bya101(connection, id);
    }

    /**
     * @param username
     * @Description: �����û���Ϣ username
     */
    @Override
    public A10 FindStaff(String username) {
        Connection connection = JDBCPoolTools.getConnection();
        daoIMP daoIMP = new daoIMP();
        A10 a10= daoIMP.SelectA10Bya103(connection,username);
        return  a10;
    }

    /**
     * @param a10
     * @Description: �޸��û�
     */
    @Override
    public void UpdateStaff(A10 a10) {
        Connection connection = JDBCPoolTools.getConnection();
        daoIMP daoIMP = new daoIMP();
        daoIMP.UpdateA10(connection, a10);
    }

    /**
     * @param a20
     * @Description: ��Ӳ���A20
     */
    @Override
    public void addPatientBasicInformation(A20 a20) {
        Connection connection = JDBCPoolTools.getConnection();
        daoIMP daoIMP = new daoIMP();
        daoIMP.A20insert(connection, a20);
    }

    /**
     * @param name
     * @param id
     * @Description: ��������
     */
    @Override
    public ArrayList<A20> FindPatients(String name, String id) {
        Connection connection = JDBCPoolTools.getConnection();
        daoIMP daoIMP = new daoIMP();
        ArrayList<A20> a20ArrayList = new ArrayList<>();
        a20ArrayList = daoIMP.SelectA20Bya201a202inDark(connection,name,id);
        return a20ArrayList;
    }

    /**
     * @param id
     * @Description: ��������(��׼)
     */
    @Override
    public A20 FindPatient(int id) {
        Connection connection = JDBCPoolTools.getConnection();
        daoIMP daoIMP = new daoIMP();
        return daoIMP.SelectA20Bya201(connection, id);
    }

    /**
     * @param a20
     * @Description: �޸Ĳ���(��׼)
     */
    @Override
    public void UpdatePatient(A20 a20) {
        Connection connection = JDBCPoolTools.getConnection();
        daoIMP daoIMP = new daoIMP();
        daoIMP.UpdateA20(connection, a20);
    }
}
