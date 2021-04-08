package jdbc;

import java.io.IOException;
import java.sql.*;

public class Insert {
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private Connection conn;
    private Statement DataRequest;

    private Insert() throws IOException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Unable to Load Driver");
            System.exit(1);
        }
        try {
            conn = DriverManager.getConnection(url, "system", "system");
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            System.exit(2);
        }

        // BufferedReader R = new BufferedReader(new InputStreamReader(System.in));
        // String name;
        // int roll = 0;
        // System.out.print("Enter Name :");
        // name = R.readLine();
        // System.out.print("Enter roll :");
        // roll = Integer.parseInt(R.readLine());
        try {
            DataRequest = conn.createStatement();
            // String query = "Insert Into system.Student Values('" + name +
            // "'," + roll +");";
            // System.out.println(DataRequest.executeUpdate(query));
            // System.out.println("Data Entered Successfully");
            /*
			 * Calling a stored procedure
			 *
			 */
            String procedure = "{CALL FACT_PRC(?)}";
            CallableStatement cstmt = conn.prepareCall(procedure);
            cstmt.setInt(1, 5);
            cstmt.execute();
        } catch (SQLException e) {
            System.out.println("Error Executing SQL Statement");
            System.exit(3);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Error Executing SQL Statement");
                System.exit(4);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // String ch;
        // do {
        new Insert();
        // System.out.println("Want to Insert More Records (y/n)");
        // BufferedReader R =
        // new BufferedReader(new InputStreamReader(System.in));
        // ch = R.readLine();
        // } while (ch.equals('y') || ch.equals("Y"));
    }
}
