package threads;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

interface IConnectionPool {
  Connection getConnection() throws InterruptedException;
  void returnConnection(Connection connection);
  void shutdown() throws SQLException;
}

public class ConnectionPool implements IConnectionPool {

  private final BlockingQueue<Connection> connectionPool;
  private int poolSize;
  private volatile boolean isShutdown = false;
  private final String driverName;
  private final String url;
  private final String username;
  private final String password;

  public ConnectionPool(int poolSize) {
    this.poolSize = poolSize;
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
    for (int i = 0; i < this.poolSize; i++) {
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

  @Override
  public void returnConnection(Connection connection) {
    if (connection != null && !isShutdown) {
      connectionPool.offer(connection);
    }
  }

  @Override
  public void shutdown() throws SQLException {
    isShutdown = true;
    for (Connection connection : connectionPool) {
      connection.close();
    }
  }

  public static void main(String[] args) throws SQLException, InterruptedException {
    IConnectionPool connectionPool = new ConnectionPool(10);
    Connection connection = connectionPool.getConnection();
    System.out.println("Got connection: " + connection);
    connectionPool.returnConnection(connection);
    System.out.println("Returned connection to pool.");
    connectionPool.shutdown();
  }
}
