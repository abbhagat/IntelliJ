package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

public class ConnectionPool {

    private String driver = "oracle.jdbc.driver.OracleDriver";
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private String username = "system";
    private String password = "zed";
    private final int MAX_POOL_SIZE = 5;

    Vector<Connection> connectionPool = new Vector<>();

    public ConnectionPool() {
        initializeConnectionPool();
    }

    public ConnectionPool(String driver, String username, String password) {
        this.driver = driver;
        this.username = username;
        this.password = password;
        initializeConnectionPool();
    }

    private synchronized void initializeConnectionPool() {
        while (!isConnectionPoolFull()) {
            connectionPool.add(creteNewConnectionForPool());
        }
        System.out.println("Connection Pool is Full");
    }

    private synchronized Connection creteNewConnectionForPool() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    private synchronized boolean isConnectionPoolFull() {
        return connectionPool.size() < MAX_POOL_SIZE ? false : true;
    }

    public synchronized Connection getConnectionFromPool() {
        Connection con = null;
        if (connectionPool.size() > 0) {
            con = connectionPool.firstElement();
            connectionPool.removeElementAt(0);
        }
        return con;
    }

    public synchronized void returnToConnectionPool(Connection con) {
        connectionPool.add(con);
    }

    public static void main(String[] args) {
        ConnectionPool pool = new ConnectionPool();
        pool.connectionPool.forEach(k -> System.out.println(k));
    }

}
