package dao;

import bean.main.A10;
import tools.JDBCPool;
import tools.JDBCPoolTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
