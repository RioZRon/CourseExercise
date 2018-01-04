package service;

import bean.main.A10;

import java.util.ArrayList;

public interface serviceForHr {
    /**
    * @Description: 添加用户信息
    **/
    void AddStaff(A10 a10);
    /**
    * @Description: 搜索用户信息
    **/
    ArrayList<A10> FindStaffs(String name, String username);

    /**
     * @Description: 搜索用户信息 username
     **/
    A10 FindStaff(String username);
    /**
    * @Description: 删除用户
    **/
    void DeleteStaff(int id);
    /**
     * @Description: 修改用户
     **/
    void UpdateStaff(A10 a10);

}
