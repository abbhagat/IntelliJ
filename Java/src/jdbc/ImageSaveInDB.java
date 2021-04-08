package jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImageSaveInDB {

    public static void main(String[] args) {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
            con.setAutoCommit(true);
            String sql = "INSERT INTO IMAGE VALUES(?,?);";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "Preity Zinta");
            FileInputStream fin = new FileInputStream("D:\\Java Study Materials\\Preity Zinta.jpg");
            ps.setBinaryStream(2, fin, fin.available());
            System.out.println("No of rows affected :" + ps.executeUpdate());
            con.commit();
            con.close();
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
