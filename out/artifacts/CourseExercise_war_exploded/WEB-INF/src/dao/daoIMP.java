package dao;

import bean.main.A10;
import bean.medicine.A60;
import bean.medicine.A62;
import bean.medicine.A63;
import bean.outpatientdocter.A21;
import bean.register.A20;
import tools.JDBCPool;
import tools.JDBCPoolTools;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class daoIMP implements daoForMain, daoForHr, daoForRegistration, daoForOutPatientDocter, daoForMedicine {
    /**
     * @param connection
     * @param name
     * @param pass
     * @Description: 取出登录得到的用户bean
     */
    @Override
    public A10 SelectA10ByA103A104(Connection connection, String name, String pass) {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            String sql = "SELECT * FROM A10 WHERE A103 = ? AND A104 = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, pass);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int a101 = resultSet.getInt("a101");
                String a102 = resultSet.getString("a102");
                String a103 = resultSet.getString("a103");
                String a104 = resultSet.getString("a104");
                int a105 = resultSet.getInt("a105");

                A10 a10 = new A10(a101, a102, a103, a104, a105);
                return a10;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCPoolTools.release(connection, preparedStatement, resultSet);
        }
        return null;
    }

    /**
     * @param connection
     * @param a10
     * @Description: 添加A10
     */
    @Override
    public void A10insert(Connection connection, A10 a10) {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            String sql = "insert into A10 values (A10_1.nextval, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, a10.getA102());
            preparedStatement.setString(2, a10.getA103());
            preparedStatement.setString(3, a10.getA104());
            preparedStatement.setInt(4, a10.getA105());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCPoolTools.release(connection, preparedStatement, resultSet);
        }
    }

    /**
     * @param connection
     * @param a102
     * @param a103
     * @Description: 通过a102 a103搜索 A10集合
     */
    @Override
    public ArrayList<A10> SelectA10Bya102a103inDark(Connection connection, String a102, String a103) {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        ArrayList<A10> a10ArrayList = new ArrayList<>();

        //模糊修改
        try {
            if (a102 == null && a103 == null) {
                String sql = "SELECT * FROM A10";
                preparedStatement = connection.prepareStatement(sql);
            } else if (a102 == null) {
                String sql = "SELECT * FROM A10 WHERE A103 LIKE " + "'%" + a103 + "%'";
                preparedStatement = connection.prepareStatement(sql);
                System.out.println(sql);
            } else if (a103 == null) {
                String sql = "SELECT * FROM A10 WHERE A102 like " + "'%" + a102 + "%'";
                preparedStatement = connection.prepareStatement(sql);
                System.out.println(sql);
            } else {
                String sql = "SELECT * FROM A10 WHERE A102 LIKE " + "'%" + a102 + "%'" + " AND A103 LIKE " + "'%" + a103 + "%'";
                preparedStatement = connection.prepareStatement(sql);
                System.out.println(sql);
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int rsa101 = resultSet.getInt("a101");
                String rsa102 = resultSet.getString("a102");
                String rsa103 = resultSet.getString("a103");
                String rsa104 = resultSet.getString("a104");
                int rsa105 = resultSet.getInt("a105");

                A10 a10 = new A10(rsa101, rsa102, rsa103, rsa104, rsa105);
                a10ArrayList.add(a10);
            }
            return a10ArrayList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCPoolTools.release(connection, preparedStatement, resultSet);
        }
        return a10ArrayList;
    }

    /**
     * @param connection
     * @param a101
     * @Description: 通过a101删除A10
     */
    @Override
    public void DeleteA10Bya101(Connection connection, int a101) {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            String sql = " DELETE FROM A10 WHERE A101 = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, a101);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCPoolTools.release(connection, preparedStatement, resultSet);
        }
    }

    /**
     * @param connection
     * @param a103
     * @Description: 通过a103搜索 A10
     */
    @Override
    public A10 SelectA10Bya103(Connection connection, String a103) {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            String sql = "SELECT * FROM A10 WHERE A103 = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, a103);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int rea101 = resultSet.getInt("a101");
                String rea102 = resultSet.getString("a102");
                String rea103 = resultSet.getString("a103");
                String rea104 = resultSet.getString("a104");
                int rea105 = resultSet.getInt("a105");
                A10 a10 = new A10(rea101, rea102, rea103, rea104, rea105);
                return a10;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCPoolTools.release(connection, preparedStatement, resultSet);
        }
        return null;
    }

    /**
     * @param connection
     * @param a10
     * @Description: 修改A10
     */
    @Override
    public void UpdateA10(Connection connection, A10 a10) {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            String sql = "UPDATE A10 SET A102 = ?, A103 = ?, A104 = ?, A105 = ? WHERE A101 = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, a10.getA102());
            preparedStatement.setString(2, a10.getA103());
            preparedStatement.setString(3, a10.getA104());
            preparedStatement.setInt(4, a10.getA105());
            preparedStatement.setInt(5, a10.getA101());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCPoolTools.release(connection, preparedStatement, resultSet);
        }
    }

    /**
     * @param connection
     * @param a20
     * @Description: 添加A20
     */
    @Override
    public void A20insert(Connection connection, A20 a20) {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            String sql = "insert into A20 values (A20_1.nextval, ?, ?, ?, ?,?,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, a20.getA202());
            preparedStatement.setInt(2, a20.getA203());
            preparedStatement.setString(3, a20.getA204());
            preparedStatement.setString(4, a20.getA205());
            preparedStatement.setString(5, a20.getA206());
            preparedStatement.setString(6, a20.getA207());
            preparedStatement.setString(7, a20.getA208());
            preparedStatement.setString(8, a20.getA209());
            preparedStatement.setInt(9, a20.getA2010());
            preparedStatement.setString(10, a20.getA2011());
            Timestamp t = new Timestamp(a20.getA2012().getTime());
            preparedStatement.setTimestamp(11, t);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCPoolTools.release(connection, preparedStatement, resultSet);
        }
    }



    /**
     * @param connection
     * @param a202
     * @param a201
     * @Description: 根据a201a202搜索A20
     */
    @Override
    public ArrayList<A20> SelectA20Bya201a202inDark(Connection connection, String a202, String a201) {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        ArrayList<A20> a20ArrayList = new ArrayList<>();
        try {
            if (a202 == null && a201 == null) {
                String sql = "SELECT * FROM A20";
                preparedStatement = connection.prepareStatement(sql);
            } else if (a202 == null) {
                String sql = "SELECT * FROM A20 WHERE A201 LIKE " + "'%" + a201 + "%'";
                preparedStatement = connection.prepareStatement(sql);
                System.out.println(sql);
            } else if (a201 == null) {
                String sql = "SELECT * FROM A20 WHERE A202 like " + "'%" + a202 + "%'";
                preparedStatement = connection.prepareStatement(sql);
                System.out.println(sql);
            } else {
                String sql = "SELECT * FROM A20 WHERE A202 LIKE " + "'%" + a202 + "%'" + " AND A201 LIKE " + "'%" + a201 + "%'";
                preparedStatement = connection.prepareStatement(sql);
                System.out.println(sql);
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int rsa201 = resultSet.getInt("A201");
                String rsa202 = resultSet.getString("a202");
                int rsa203 = resultSet.getInt("A203");
                String rsa204 = resultSet.getString("A204");
                String rsa205 = resultSet.getString("A205");
                String rsa206 = resultSet.getString("A206");
                String rsa207 = resultSet.getString("A207");
                String rsa208 = resultSet.getString("A208");
                String rsa209 = resultSet.getString("A209");
                int rsa2010 = resultSet.getInt("A2010");
                String rsa2011 = resultSet.getString("A2011");
                Timestamp rsa2012ts = resultSet.getTimestamp("A2012");
                Date rsa2012 = new Date(rsa2012ts.getTime());
                A20 a20 = new A20(rsa201, rsa203, rsa2010, rsa202, rsa204, rsa205, rsa206, rsa207, rsa208, rsa209, rsa2011, rsa2012);
                a20ArrayList.add(a20);
            }
            return a20ArrayList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCPoolTools.release(connection, preparedStatement, resultSet);
        }
        return null;
    }


    /**
     * @param connection
     * @param a201
     * @Description: 根据201搜索A20
     */
    @Override
    public A20 SelectA20Bya201(Connection connection, int a201) {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            String sql = "SELECT * FROM A20 WHERE A201 = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, a201);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int rsa201 = resultSet.getInt("A201");
                String rsa202 = resultSet.getString("a202");
                int rsa203 = resultSet.getInt("A203");
                String rsa204 = resultSet.getString("A204");
                String rsa205 = resultSet.getString("A205");
                String rsa206 = resultSet.getString("A206");
                String rsa207 = resultSet.getString("A207");
                String rsa208 = resultSet.getString("A208");
                String rsa209 = resultSet.getString("A209");
                int rsa2010 = resultSet.getInt("A2010");
                String rsa2011 = resultSet.getString("A2011");
                Timestamp rsa2012ts = resultSet.getTimestamp("A2012");
                Date rsa2012 = new Date(rsa2012ts.getTime());
                A20 a20 = new A20(rsa201, rsa203, rsa2010, rsa202, rsa204, rsa205, rsa206, rsa207, rsa208, rsa209, rsa2011, rsa2012);
                return a20;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCPoolTools.release(connection, preparedStatement, resultSet);
        }
        return null;
    }

    /**
     * @param connection
     * @param a20
     * @Description: 修改A20
     */
    @Override
    public void UpdateA20(Connection connection, A20 a20) {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            String sql = "UPDATE A20 SET A202 = ?, A203 = ?, A204 = ?, A205 = ? , A206 = ?, A207 = ?, A208 = ?, A209 = ?,  A2010 = ?,  A2011 = ?,  A2012 = ? WHERE A201 = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, a20.getA202());
            preparedStatement.setInt(2, a20.getA203());
            preparedStatement.setString(3, a20.getA204());
            preparedStatement.setString(4, a20.getA205());
            preparedStatement.setString(5, a20.getA206());
            preparedStatement.setString(6, a20.getA207());
            preparedStatement.setString(7, a20.getA208());
            preparedStatement.setString(8, a20.getA209());
            preparedStatement.setInt(9, a20.getA2010());
            preparedStatement.setString(10, a20.getA2011());
            Timestamp t = new Timestamp(a20.getA2012().getTime());
            preparedStatement.setTimestamp(11, t);
            preparedStatement.setInt(12, a20.getA201());
            System.out.println(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCPoolTools.release(connection, preparedStatement, resultSet);
        }
    }

    /**
     * @param connection
     * @param a131
     * @Description: 根据131得到133
     */
    @Override
    public int Selecta133Bya131(Connection connection, int a131) {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        int a133 = 0;
        try {
            String sql = "SELECT * FROM A13 WHERE A131 = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, a131);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                a133 = resultSet.getInt("A133");
            }
            return a133;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCPoolTools.release(connection, preparedStatement, resultSet);
        }
        return a133;
    }

    /**
     * @param connection
     * @param a2010
     * @Description:
     */
    @Override
    public ArrayList<A20> SelectA20Bya2010(Connection connection, int a2010) {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        ArrayList<A20> a20ArrayList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM A20 WHERE A2010 = ? AND (A2011<>'Done' or A2011 is null)order by A201 asc";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, a2010);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int rsa201 = resultSet.getInt("A201");
                String rsa202 = resultSet.getString("a202");
                int rsa203 = resultSet.getInt("A203");
                String rsa204 = resultSet.getString("A204");
                String rsa205 = resultSet.getString("A205");
                String rsa206 = resultSet.getString("A206");
                String rsa207 = resultSet.getString("A207");
                String rsa208 = resultSet.getString("A208");
                String rsa209 = resultSet.getString("A209");
                int rsa2010 = resultSet.getInt("A2010");
                String rsa2011 = resultSet.getString("A2011");
                Timestamp rsa2012ts = resultSet.getTimestamp("A2012");
                Date rsa2012 = new Date(rsa2012ts.getTime());
                A20 a20 = new A20(rsa201, rsa203, rsa2010, rsa202, rsa204, rsa205, rsa206, rsa207, rsa208, rsa209, rsa2011, rsa2012);
                a20ArrayList.add(a20);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCPoolTools.release(connection, preparedStatement, resultSet);
        }
        return a20ArrayList;
    }

    /**
     * @param connection
     * @param a211
     * @Description:根据a211搜索a21
     */
    @Override
    public A21 SelectA21Bya211(Connection connection, int a211) {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            String sql = "SELECT * FROM A21 WHERE A211 = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, a211);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int rsa211 = resultSet.getInt("A211");
                String rsa212 = resultSet.getString("a212");
                String rsa213 = resultSet.getString("A213");
                String rsa214 = resultSet.getString("A214");
                String rsa215 = resultSet.getString("A215");
                String rsa216 = resultSet.getString("A216");
                String rsa217 = resultSet.getString("A217");
                String rsa218 = resultSet.getString("A218");
                String rsa219 = resultSet.getString("A219");
                A21 a21 = new A21(rsa211,rsa212,rsa213,rsa214,rsa215,rsa216,rsa217,rsa218,rsa219);
                return a21;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCPoolTools.release(connection, preparedStatement, resultSet);
        }
        return null;
    }

    /**
     * @param connection
     * @param a211
     * @Description: 依靠a211添加a21
     */
    @Override
    public void A21insertBya211(Connection connection, int a211) {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            String sql = "insert into A21 (A211) values (?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, a211);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCPoolTools.release(connection, preparedStatement, resultSet);
        }
    }

    /**
     * @param connection
     * @param a21
     * @Description: 修改A21
     */
    @Override
    public void UpdateA21(Connection connection, A21 a21) {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            String sql = "UPDATE A21 SET A212 = ?, A213 = ?, A214 = ?, A215 = ? , A216 = ?, A217 = ?, A218 = ?, A219 = ?  WHERE A211 = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, a21.getA212());
            preparedStatement.setString(2, a21.getA213());
            preparedStatement.setString(3, a21.getA214());
            preparedStatement.setString(4, a21.getA215());
            preparedStatement.setString(5, a21.getA216());
            preparedStatement.setString(6, a21.getA217());
            preparedStatement.setString(7, a21.getA218());
            preparedStatement.setString(8, a21.getA219());
            preparedStatement.setInt(9, a21.getA211());
            System.out.println(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCPoolTools.release(connection, preparedStatement, resultSet);
        }
    }

    /**
     * @param connection
     * @param a601
     * @param a607
     * @Description: 用a607更新A60
     */
    @Override
    public void UpdateA60Bya607(Connection connection, int a601, String a607) {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            String sql = "UPDATE A60 SET A607 = ? WHERE A601 = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, a607);
            preparedStatement.setInt(2, a601);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCPoolTools.release(connection, preparedStatement, resultSet);
        }
    }

    /**
     * @param connection
     * @Description: 所有药瓶药品
     */
    @Override
    public ArrayList<A60> SelectAllA60(Connection connection) {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        ArrayList<A60> a60ArrayList = new ArrayList<>();
        try {
            String sql = "SELECT A601,A602,A606,A607,A608 FROM A60";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int rsa601 = resultSet.getInt("A601");
                String rsa602 = resultSet.getString("a602");
                int rsa606 = resultSet.getInt("A606");
                String rsa607 = resultSet.getString("A607");
                int rsa608 = resultSet.getInt("A608");
                A60 a60 = new A60(rsa601, rsa602, rsa606, rsa607, rsa608);
                a60ArrayList.add(a60);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCPoolTools.release(connection, preparedStatement, resultSet);
        }
        return a60ArrayList;
    }

    /**
     * @param connection
     * @param a601
     * @Description: 根据A601 搜索A60
     */
    @Override
    public A60 SelectA60ByA601(Connection connection, int a601) {
        A60 a60 = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            String sql = "SELECT * FROM A60 WHERE A601 = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, a601);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int rsa601 = resultSet.getInt("A601");
                String rsa602 = resultSet.getString("a602");
                int rsa603 = resultSet.getInt("A603");
                String rsa604 = resultSet.getString("A604");
                int rsa605 = resultSet.getInt("A605");
                int rsa606 = resultSet.getInt("A606");
                String rsa607 = resultSet.getString("A607");
                int rsa608 = resultSet.getInt("A608");
                String rsa609 = resultSet.getString("A609");
                String rsa6010 = resultSet.getString("A6010");
                a60 = new A60(rsa601,rsa605,rsa606,rsa608,rsa602,rsa603,rsa604,rsa607,rsa609,rsa6010);
//                System.out.println(a60.toString());
                return a60;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCPoolTools.release(connection, preparedStatement, resultSet);
        }
     return null;
    }

    /**
     * @param connection
     * @param a62
     * @Description: 添加A62流水表
     */
    @Override
    public void A62insert(Connection connection, A62 a62) {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            String sql = "insert into A62 values (A62_1.nextval, ?, ?, ?, ?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, a62.getA622());
            preparedStatement.setString(2, a62.getA623());
            preparedStatement.setDate(3, a62.getA624());
            preparedStatement.setInt(4, a62.getA625());
            preparedStatement.setString(5, a62.getA626());
            preparedStatement.setInt(6, a62.getA627());
            preparedStatement.setDate(7, a62.getA628());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCPoolTools.release(connection, preparedStatement, resultSet);
        }
    }

    /**
     * @param connection
     * @param a63
     * @Description: 添加A63流水表
     */
    @Override
    public void A63insert(Connection connection, A63 a63) {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            String sql = "insert into A63 values (A63_1.nextval, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, a63.getA632());
            preparedStatement.setString(2, a63.getA633());
            preparedStatement.setDate(3, a63.getA634());
            preparedStatement.setInt(4, a63.getA635());
            preparedStatement.setInt(5, a63.getA636());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCPoolTools.release(connection, preparedStatement, resultSet);
        }
    }

    /**
     * @param connection
     * @param a601
     * @param a607
     * @Description: 修改A60的A607
     */
    @Override
    public void Updatea607Bya601(Connection connection, int a601, String a607) {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            String sql = "UPDATE A60 SET A607 = ? WHERE A601 = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, a607);
            preparedStatement.setInt(2,a601);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCPoolTools.release(connection, preparedStatement, resultSet);
        }
    }

    /**
     * @param connection
     * @param a602
     * @param a601
     * @Description: 根据601602模糊查询60表
     */
    @Override
    public ArrayList<A60> SelectA60Bya601a602inDark(Connection connection, String a602, String a601) {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        ArrayList<A60> a60ArrayList = new ArrayList<>();
        try {
            if (a602 == null && a601 == null) {
                String sql = "SELECT * FROM A60";
                preparedStatement = connection.prepareStatement(sql);
            } else if (a602 == null) {
                String sql = "SELECT * FROM A60 WHERE A601 LIKE " + "'%" + a601 + "%'";
                preparedStatement = connection.prepareStatement(sql);
                System.out.println(sql);
            } else if (a601 == null) {
                String sql = "SELECT * FROM A60 WHERE A602 like " + "'%" + a602 + "%'";
                preparedStatement = connection.prepareStatement(sql);
                System.out.println(sql);
            } else {
                String sql = "SELECT * FROM A60 WHERE A602 LIKE " + "'%" + a602 + "%'" + " AND A601 LIKE " + "'%" + a601 + "%'";
                preparedStatement = connection.prepareStatement(sql);
                System.out.println(sql);
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int rsa601 = resultSet.getInt("A601");
                String rsa602 = resultSet.getString("a602");
                int rsa603 = resultSet.getInt("A603");
                String rsa604 = resultSet.getString("A604");
                int rsa605 = resultSet.getInt("A605");
                int rsa606 = resultSet.getInt("A606");
                String rsa607 = resultSet.getString("A607");
                int rsa608 = resultSet.getInt("A608");
                String rsa609 = resultSet.getString("A609");
                String rsa6010 = resultSet.getString("A6010");
                A60 a60 = new A60(rsa601,rsa605,rsa606,rsa608,rsa602,rsa603,rsa604,rsa607,rsa609,rsa6010);
//                System.out.println(a60.toString());
                a60ArrayList.add(a60);
            }
            return a60ArrayList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCPoolTools.release(connection, preparedStatement, resultSet);
        }
        return null;
    }

    /**
     * @param connection
     * @param a60
     * @Description: 更新A60
     */
    @Override
    public void UpdateA60(Connection connection, A60 a60) {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            String sql = "UPDATE A60 SET A602 = ?, A603 = ?, A604 = ?, A605 = ? , A606 = ?, A607 = ?, A608 = ?, A609 = ?  WHERE A601 = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, a60.getA602());
            preparedStatement.setInt(2, a60.getA603());
            preparedStatement.setString(3, a60.getA604());
            preparedStatement.setInt(4, a60.getA605());
            preparedStatement.setInt(5, a60.getA606());
            preparedStatement.setString(6, a60.getA607());
            preparedStatement.setInt(7, a60.getA608());
            preparedStatement.setString(8, a60.getA609());
            preparedStatement.setString(9, a60.getA6010());
            preparedStatement.setInt(9, a60.getA601());
//            System.out.println(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCPoolTools.release(connection, preparedStatement, resultSet);
        }
    }

    /**
     * @param connection
     * @param a60
     * @Description: 添加A60
     */
    @Override
    public void A60insert(Connection connection, A60 a60) {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            String sql = "insert into A60 values (A60_1.nextval, ?, ?, ?, ?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, a60.getA602());
            preparedStatement.setInt(2, a60.getA603());
            preparedStatement.setString(3, a60.getA604());
            preparedStatement.setInt(4, a60.getA605());
            preparedStatement.setInt(5, a60.getA606());
            preparedStatement.setString(6, a60.getA607());
            preparedStatement.setInt(7, a60.getA608());
            preparedStatement.setString(8, a60.getA609());
            preparedStatement.setString(9, a60.getA6010());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCPoolTools.release(connection, preparedStatement, resultSet);
        }
    }

    /**
     * @param connection
     * @param a602
     * @Description: 根据唯一名 查询编号
     */
    @Override
    public int Selecta601Bya602(Connection connection, String a602) {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        int a601 = 0;
        try {
            String sql = "SELECT A601 FROM A60 WHERE A602 = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, a602);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                a601 = resultSet.getInt("A601");
            }
            return a601;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCPoolTools.release(connection, preparedStatement, resultSet);
        }
        return a601;
    }

    /**
     * @param connection
     * @param a211
     * @Description: 根据id 查询
     */
    @Override
    public String Selecta217Bya211(Connection connection, int a211) {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        String a217 = null;
        try {
            String sql = "SELECT A217 FROM A21 WHERE A211 = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, a211);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                a217 = resultSet.getString("A217");
            }
            return a217;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCPoolTools.release(connection, preparedStatement, resultSet);
        }
        return a217;
    }

    /**
     * @param connection
     * @param limitScope
     * @Description: 根据A602的范围搜索得到A60集合
     */
    @Override
    public ArrayList<A60> SelectA60sBya602(Connection connection, String limitScope) {
        ArrayList<A60> a60ArrayList = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            String sql = "SELECT * FROM A60 WHERE A602 IN (" + limitScope + ")";
            preparedStatement = connection.prepareStatement(sql);
            System.out.println(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int rsa601 = resultSet.getInt("A601");
                String rsa602 = resultSet.getString("a602");
                int rsa603 = resultSet.getInt("A603");
                String rsa604 = resultSet.getString("A604");
                int rsa605 = resultSet.getInt("A605");
                int rsa606 = resultSet.getInt("A606");
                String rsa607 = resultSet.getString("A607");
                int rsa608 = resultSet.getInt("A608");
                String rsa609 = resultSet.getString("A609");
                String rsa6010 = resultSet.getString("A6010");
                A60 a60 = new A60(rsa601,rsa605,rsa606,rsa608,rsa602,rsa603,rsa604,rsa607,rsa609,rsa6010);
                a60ArrayList.add(a60);
            }
            return a60ArrayList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCPoolTools.release(connection, preparedStatement, resultSet);
        }
        return null;
    }

    /**
     * @param connection
     * @param a601
     * @Description: 根据601搜索最近一次进价
     */
    @Override
    public int Selecta627Bya601(Connection connection, int a601) {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        int a627 = 0;
        try {
            String sql = "SELECT a627 FROM A62 WHERE a622 = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, a601);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                a627 = resultSet.getInt("a627");
            }
            return a627;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCPoolTools.release(connection, preparedStatement, resultSet);
        }
        return a627;
    }

    /**
     * @param connection
     * @param a211
     * @param a217
     * @Description:根据a211修改a217
     */
    @Override
    public void Updatea217Bya211(Connection connection, int a211, String a217) {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            String sql = "UPDATE A21 SET A217 = ? WHERE A211 = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, a217);
            preparedStatement.setInt(2,a211);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCPoolTools.release(connection, preparedStatement, resultSet);
        }
    }
}
