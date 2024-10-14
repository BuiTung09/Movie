
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {

    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=DBTest"; // URL kết nối đến DB
    private static final String USER = "tungbx";  // Tên người dùng
    private static final String PASS = "1234";    // Mật khẩu

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // Nạp Driver SQL Server
        return DriverManager.getConnection(URL, USER, PASS); // Mở kết nối tới DB
    }
}
