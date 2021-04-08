package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection implements Cloneable {
    private static Connection con;
    private static String url = "jdbc:oracle:thin:@localhost:1521:xe";

    private JdbcConnection() {

    }

    public Object clone() {
        try {
            throw new CloneNotSupportedException("Connection Object already instantiated");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static Connection getConnection() {
        if (con == null) {
            synchronized (JdbcConnection.class) {
                try {
                    if (con == null) {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        con = DriverManager.getConnection(url, "system", "zed");
                    }
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return con;
    }

    public static void main(String[] args) throws SQLException {
        Connection con = JdbcConnection.getConnection();
        System.out.println("Database connection established successfully");
        con.close();
        System.gc();
    }
}
