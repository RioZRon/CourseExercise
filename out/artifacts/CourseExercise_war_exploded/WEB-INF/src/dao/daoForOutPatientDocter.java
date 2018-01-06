package dao;

import bean.main.A10;
import bean.outpatientdocter.A21;
import bean.register.A20;

import java.sql.Connection;
import java.util.ArrayList;

public interface daoForOutPatientDocter {
   /**
   * @Description: 根据131得到133
   **/
   int Selecta133Bya131(Connection connection, int a131);

   /**
   * @Description:根据2010搜索A20
   **/
   ArrayList<A20> SelectA20Bya2010(Connection connection, int a2010);

   /**
   * @Description:根据a211搜索a21
   **/
   A21 SelectA21Bya211(Connection connection, int a211);

   /**
   * @Description: 依靠a211添加a21
   **/
   void A21insertBya211(Connection connection, int a211);

   /**
   * @Description: 修改A21
   **/
   void UpdateA21(Connection connection, A21 a21);
}
