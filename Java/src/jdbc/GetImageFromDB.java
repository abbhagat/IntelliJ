package jdbc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

public class GetImageFromDB {

    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
            String sql = "Select * from IMAGE_T";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Blob b = rs.getBlob(2);
                byte[] bytes = b.getBytes(1, (int) b.length());
                FileOutputStream fos = new FileOutputStream("D:\\Preity Zinta.jpg");
                fos.write(bytes);
                fos.flush();
                fos.close();
            }
        } catch (ClassNotFoundException | IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
