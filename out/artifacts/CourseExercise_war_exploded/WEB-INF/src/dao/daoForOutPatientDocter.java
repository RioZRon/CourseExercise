package dao;

import bean.main.A10;
import bean.outpatientdocter.A21;
import bean.register.A20;

import java.sql.Connection;
import java.util.ArrayList;

public interface daoForOutPatientDocter {
   /**
   * @Description: ����131�õ�133
   **/
   int Selecta133Bya131(Connection connection, int a131);

   /**
   * @Description:����2010����A20
   **/
   ArrayList<A20> SelectA20Bya2010(Connection connection, int a2010);

   /**
   * @Description:����a211����a21
   **/
   A21 SelectA21Bya211(Connection connection, int a211);

   /**
   * @Description: ����a211���a21
   **/
   void A21insertBya211(Connection connection, int a211);

   /**
   * @Description: �޸�A21
   **/
   void UpdateA21(Connection connection, A21 a21);
}
