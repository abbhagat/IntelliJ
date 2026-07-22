package lld.connectionpool;

import lombok.Getter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.*;

public class ConnectionPool implements IConnectionPool {

  @Getter
  private final BlockingQueue<Connection> queue;
  private final int poolSize;
  private final String driverName;
  private final String url;
  private final String username;
  private final String password;
  private volatile boolean isPoolClosed;

  public BlockingQueue<Connection> getConnectionPool() {
    return this.queue;
  }

  public ConnectionPool(int poolSize) {
    this("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:@localhost:1521:XE", "system", "zed", poolSize);
  }

  public ConnectionPool(String driverName, String url, String username, String password, int poolSize) {
    this.driverName = driverName;
    this.url = url;
    this.username = username;
    this.password = password;
    this.poolSize = poolSize;
    this.queue = new ArrayBlockingQueue<>(poolSize);
    initializeConnectionPool();
  }

  private void initializeConnectionPool() {
    for (int i = 0; i < this.poolSize; i++) {
      queue.add(createNewConnection());
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
  public Connection get() throws InterruptedException {
    if (isPoolClosed) {
      throw new IllegalStateException("Connection pool is closed");
    }
    return queue.take();
  }

  @Override
  public boolean put(Connection connection) {
    if (connection != null && !isPoolClosed) {
      return queue.offer(connection);
    }
    return false;
  }

  @Override
  public synchronized void stop() throws SQLException {
    isPoolClosed = true;
    for (Connection connection : queue) {
      connection.close();
    }
    System.out.println("Connection Pool is Stopped");
  }
}
