package service;

import bean.main.A10;

import java.util.ArrayList;

public interface serviceForHr {
    /**
    * @Description: ����û���Ϣ
    **/
    void AddStaff(A10 a10);
    /**
    * @Description: �����û���Ϣ
    **/
    ArrayList<A10> FindStaffs(String name, String username);

    /**
     * @Description: �����û���Ϣ username
     **/
    A10 FindStaff(String username);
    /**
    * @Description: ɾ���û�
    **/
    void DeleteStaff(int id);
    /**
     * @Description: �޸��û�
     **/
    void UpdateStaff(A10 a10);

}
