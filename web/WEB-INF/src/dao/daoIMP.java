package dao;

import bean.main.A10;
import tools.JDBCPool;
import tools.JDBCPoolTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class daoIMP implements daoForMain, daoForHr {
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
//                System.out.println(a10.toString());
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
        try{
            if(a102 == null && a103 == null){
                String sql = "SELECT * FROM A10";
                preparedStatement = connection.prepareStatement(sql);
            }else if(a102 == null){
                String sql = "SELECT * FROM A10 WHERE A103 LIKE " +  "'%"+a103+"%'";
                preparedStatement = connection.prepareStatement(sql);
                System.out.println(sql);
            }else if(a103 == null){
                String sql = "SELECT * FROM A10 WHERE A102 like " + "'%"+a102+"%'";
                preparedStatement = connection.prepareStatement(sql);
                System.out.println(sql);
            }else {
                String sql = "SELECT * FROM A10 WHERE A102 LIKE "+"'%"+a102+"%'"+" AND A103 LIKE "+"'%"+a103+"%'";
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
            if (resultSet.next())
            {
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
}
