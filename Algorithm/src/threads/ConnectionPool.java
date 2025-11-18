package threads;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

public class ConnectionPool {

  private static final Vector<Connection> connectionPool = new Vector<>();
  private static final int MAX_POOL_SIZE = 10;
  private final String driverName;
  private final String url;
  private final String username;
  private final String password;

  public ConnectionPool() {
    this.driverName = "oracle.jdbc.driver.OracleDriver";
    this.url = "jdbc:oracle:thin:@localhost:1521:XE";
    this.username = "system";
    this.password = "zed";
    initializeConnectionPool();
  }

  public ConnectionPool(String driverName, String url, String username, String password) {
    this.driverName = driverName;
    this.url = url;
    this.username = username;
    this.password = password;
    initializeConnectionPool();
  }

  public static void main(String[] args) throws SQLException {
    ConnectionPool connectionPool = new ConnectionPool();
    Connection connection = connectionPool.getConnectionFromPool();
    System.out.println("Got connection: " + connection);
    connectionPool.returnConnectionToPool(connection);
    System.out.println("Returned connection to pool.");
    connection.close();
  }

  private void initializeConnectionPool() {
    while (connectionPool.size() < MAX_POOL_SIZE) {
      connectionPool.add(getConnection());
    }
  }

  private Connection getConnection() {
    Connection connection = null;
    try {
      Class.forName(this.driverName);
      connection = DriverManager.getConnection(this.url, this.username, this.password);
    } catch (ClassNotFoundException | SQLException e) {
      System.out.println("Exception occurred with " + e.getMessage());
    }
    return connection;
  }

  public synchronized Connection getConnectionFromPool() {
    Connection connection = connectionPool.firstElement();
    connectionPool.removeElementAt(0);
    return connection;
  }

  public synchronized void returnConnectionToPool(Connection connection) {
    connectionPool.add(connection);
  }
}
