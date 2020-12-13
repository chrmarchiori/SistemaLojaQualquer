// BDGenericoDAO.java
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenericDAO {
	static String USER = "root";
	static String PASSWORD = "root";
	
    protected Connection getConnection() throws SQLException {
        String urlJDBC = "jdbc:mysql://localhost:3306/";
        Connection connection = DriverManager.getConnection(urlJDBC, USER, PASSWORD);
        return connection;
    }

    protected Connection getConnection(String database) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String urlJDBC = "jdbc:mysql://localhost:3306/" + database;
        Connection connection = DriverManager.getConnection(urlJDBC, USER, PASSWORD);
        return connection;
    }

    protected void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void close(PreparedStatement pstmt) {
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}