package lld.connectionpool;

import lombok.Getter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionPool implements IConnectionPool {

  @Getter
  private final BlockingQueue<Connection> connectionPool;

  private final int poolSize;
  private final String driverName;
  private final String url;
  private final String username;
  private final String password;
  private volatile boolean isPoolClosed;

  public ConnectionPool(int poolSize) {
    this("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:@localhost:1521:XE", "system", "zed", poolSize);
  }

  public ConnectionPool(String driverName, String url, String username, String password, int poolSize) {
    this.driverName = driverName;
    this.url = url;
    this.username = username;
    this.password = password;
    this.poolSize = poolSize;
    this.connectionPool = new ArrayBlockingQueue<>(poolSize);
    initializeConnectionPool();
  }

  private void initializeConnectionPool() {
    for (int i = 0; i < this.poolSize; i++) {
      connectionPool.add(createNewConnection());
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
    if (isPoolClosed) {
      throw new IllegalStateException("Connection pool is closed");
    }
    return connectionPool.take();
  }

  @Override
  public boolean returnConnection(Connection connection) {
    if (connection != null && !isPoolClosed) {
      return connectionPool.offer(connection);
    }
    return false;
  }

  @Override
  public synchronized void stop() throws SQLException {
    this.isPoolClosed = true;
    for (Connection connection : this.connectionPool) {
      connection.close();
    }
    System.out.println("Connection Pool is Stopped");
  }

  public static void main(String[] args) throws SQLException, InterruptedException {
    ConnectionPool connectionPool = new ConnectionPool(10);
    AtomicInteger atomicInteger = new AtomicInteger(1);
    connectionPool.getConnectionPool().forEach(connection -> {
      System.out.println("Connection " + atomicInteger.getAndIncrement() + " " + connection);
    });
    Connection connection = connectionPool.getConnection();
    System.out.println("Got connection: " + connection);
    System.out.println("Returned connection to pool " + connectionPool.returnConnection(connection));
    connectionPool.stop();
  }
}
