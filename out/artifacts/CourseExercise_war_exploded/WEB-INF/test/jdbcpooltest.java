import bean.medicine.A60;
import dao.daoIMP;
import service.serviceIMP;
import tools.JDBCPool;
import tools.JDBCPoolTools;
import tools.StringTools;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class jdbcpooltest {
    public static void main(String[] args) {

        serviceIMP serviceIMP = new serviceIMP();
        String test = "栀子花金片*3 已取,  六味地黄丸*1, ceshi1*1";
//        serviceIMP.ShowAllNeededMedicine(test);
        String res = StringTools.PrescriptionMapToString(StringTools.PrescriptionStringToMap(test));
        System.out.println(res);
//
//        int test2 = 22;
//        System.out.println(serviceIMP.SelectInprice(test2));

    }
}