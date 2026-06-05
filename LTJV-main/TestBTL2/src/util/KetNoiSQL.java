package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KetNoiSQL {
    // Thay đổi thông tin cấu hình phù hợp với máy của bạn
    private static final String HOSTNAME = "localhost";
    private static final String PORT = "1433";
    private static final String DATABASE_NAME = "QuanLyHocVu";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "123";

    public static Connection KetNoi() {
        try {
            String connectionUrl = "jdbc:sqlserver://" + HOSTNAME + ":" + PORT + ";"
                    + "databaseName=" + DATABASE_NAME + ";"
                    + "user=" + USERNAME + ";"
                    + "password=" + PASSWORD + ";"
                    + "encrypt=true;trustServerCertificate=true;";
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            return DriverManager.getConnection(connectionUrl);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Lỗi kết nối CSDL: " + e.getMessage());
            return null;
        }
    }
}