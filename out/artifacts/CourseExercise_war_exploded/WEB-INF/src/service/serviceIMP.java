package service;

import bean.main.A10;
import bean.outpatientdocter.A21;
import bean.register.A20;
import dao.daoIMP;
import tools.JDBCPool;
import tools.JDBCPoolTools;

import java.sql.Connection;
import java.util.ArrayList;

public class serviceIMP implements serviceForMain, serviceForHr, serviceForRegistration, serviceForOutPatientDocter{
    /**
     * @param name
     * @param pass
     * @Description: 取出登录得到的用户bean
     */
    @Override
    public A10 SignIn(String name, String pass) {
        Connection connection = JDBCPoolTools.getConnection();
        daoIMP daoImp = new daoIMP();
//        System.out.println(name + pass);
        A10 a10= daoImp.SelectA10ByA103A104(connection, name, pass);
//        System.out.println(a10.toString());
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

    /**
     * @param name  没有为null
     * @param username  没有就为null
     * @Description: 搜索用户信息
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
     * @Description: 删除用户
     */
    @Override
    public void DeleteStaff(int id) {
        Connection connection = JDBCPoolTools.getConnection();
        daoIMP daoIMP = new daoIMP();
        daoIMP.DeleteA10Bya101(connection, id);
    }

    /**
     * @param username
     * @Description: 搜索用户信息 username
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
     * @Description: 修改用户
     */
    @Override
    public void UpdateStaff(A10 a10) {
        Connection connection = JDBCPoolTools.getConnection();
        daoIMP daoIMP = new daoIMP();
        daoIMP.UpdateA10(connection, a10);
    }

    /**
     * @param a20
     * @Description: 添加病人A20
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
     * @Description: 搜索病人
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
     * @Description: 搜索病人(精准)
     */
    @Override
    public A20 FindPatient(int id) {
        Connection connection = JDBCPoolTools.getConnection();
        daoIMP daoIMP = new daoIMP();
        return daoIMP.SelectA20Bya201(connection, id);
    }

    /**
     * @param a20
     * @Description: 修改病人(精准)
     */
    @Override
    public void UpdatePatient(A20 a20) {
        Connection connection = JDBCPoolTools.getConnection();
        daoIMP daoIMP = new daoIMP();
        daoIMP.UpdateA20(connection, a20);
    }

    /**
     * @param id
     * @Description: 得到医生对应的科室
     */
    @Override
    public int FindDoctorRoom(int id) {
        Connection connection = JDBCPoolTools.getConnection();
        daoIMP daoIMP = new daoIMP();
        int roomid = daoIMP.Selecta133Bya131(connection, id);
        return roomid;
    }

    /**
     * @param a2010
     * @Description: 搜索所有分配到这个科室的病人
     */
    @Override
    public ArrayList<A20> FindPatientsBya2010(int a2010) {
        Connection connection = JDBCPoolTools.getConnection();
        daoIMP daoIMP = new daoIMP();
        ArrayList<A20> a20ArrayList = new ArrayList<>();
        a20ArrayList = daoIMP.SelectA20Bya2010(connection,a2010);
        return a20ArrayList;
    }

    /**
     * @param a201
     * @Description: 根据挂号查询病历
     */
    @Override
    public A21 FindMedicalrecord(int a211) {
        Connection connection = JDBCPoolTools.getConnection();
        daoIMP daoIMP = new daoIMP();
        return daoIMP.SelectA21Bya211(connection, a211);
    }

    /**
     * @param a21
     * @Description: 添加病历(目前添加的都是空的 只有标号 信息全靠update)
     */
    @Override
    public void addEmptyFindMedicalrecord(A21 a21) {
        Connection connection = JDBCPoolTools.getConnection();
        daoIMP daoIMP = new daoIMP();
        daoIMP.A21insertBya211(connection, a21.getA211());
    }

    /**
     * @param a21
     * @Description: 修改A21
     */
    @Override
    public void UpdateMedicalrecord(A21 a21) {
        Connection connection = JDBCPoolTools.getConnection();
        daoIMP daoIMP = new daoIMP();
        daoIMP.UpdateA21(connection, a21);

    }
}
