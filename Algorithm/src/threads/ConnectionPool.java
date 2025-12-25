package threads;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

interface IConnectionPool {
  Connection getConnection() throws InterruptedException;
  void releaseConnection(Connection connection);
  void shutdown();
}

public class ConnectionPool implements IConnectionPool {

  private final BlockingQueue<Connection> connectionPool;
  private int poolSize = 10;
  private volatile boolean isShutdown = false;
  private final String driverName;
  private final String url;
  private final String username;
  private final String password;

  public ConnectionPool() {
    this.connectionPool = new ArrayBlockingQueue<>(poolSize);
    this.driverName = "oracle.jdbc.driver.OracleDriver";
    this.url = "jdbc:oracle:thin:@localhost:1521:XE";
    this.username = "system";
    this.password = "zed";
    initializeConnectionPool();
  }

  public ConnectionPool(String driverName, String url, String username, String password, int poolSize) {
    this.poolSize = poolSize;
    this.connectionPool = new ArrayBlockingQueue<>(poolSize);
    this.driverName = driverName;
    this.url = url;
    this.username = username;
    this.password = password;
    initializeConnectionPool();
  }

  private void initializeConnectionPool() {
    while (connectionPool.size() < poolSize) {
      connectionPool.offer(createNewConnection());
    }
  }

  public Connection createNewConnection() {
    Connection connection = null;
    try {
      Class.forName(this.driverName);
      connection = DriverManager.getConnection(this.url, this.username, this.password);
    } catch (ClassNotFoundException | SQLException e) {
      System.out.println("Exception occurred with " + e.getMessage());
    }
    return connection;
  }

  @Override
  public Connection getConnection() throws InterruptedException {
    if (isShutdown) {
      throw new IllegalStateException("Connection pool is shutdown");
    }
    return connectionPool.take();
  }

  public void releaseConnection(Connection connection) {
    if (connection != null && !isShutdown) {
      connectionPool.offer(connection);
    }
  }

  @Override
  public void shutdown() {
    isShutdown = true;
    connectionPool.forEach(connection -> {
      try {
        connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    });
  }

  public static void main(String[] args) throws SQLException, InterruptedException {
    IConnectionPool connectionPool = new ConnectionPool();
    Connection connection = connectionPool.getConnection();
    System.out.println("Got connection: " + connection);
    connectionPool.releaseConnection(connection);
    System.out.println("Returned connection to pool.");
    connection.close();
  }
}
