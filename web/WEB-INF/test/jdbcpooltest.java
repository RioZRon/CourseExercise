import bean.medicine.A60;
import dao.daoIMP;
import tools.JDBCPool;
import tools.JDBCPoolTools;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class jdbcpooltest {
    public static void main(String[] args) {
        Connection connection =JDBCPoolTools.getConnection();
        daoIMP daoIMP = new daoIMP();
        ArrayList<A60> a60s = daoIMP.SelectAllA60(connection);
//        Iterator<A60> iterator = a60s.iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next().toString());
//        }
        for (A60 a60 : a60s){
            System.out.println(a60.toString());
        }

    }
}