package lld.connectionpool;

import lombok.Getter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.*;
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
    isPoolClosed = true;
    for (Connection connection : connectionPool) {
      connection.close();
    }
    System.out.println("Connection Pool is Stopped");
  }

  public static void main(String[] args) throws SQLException, InterruptedException {
    ConnectionPool connectionPool = new ConnectionPool(5);
    AtomicInteger atomicInteger = new AtomicInteger(1);
    connectionPool.getConnectionPool().forEach(connection -> {
      System.out.println("Connection " + atomicInteger.getAndIncrement() + " " + connection);
    });
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    for (int i = 1; i <= 10; i++) {
      int threadId = i;
      executorService.submit(() -> {
        try {
          System.out.println("Thread-" + threadId + " trying to get connection...");
          Connection conn = connectionPool.getConnection();  // BLOCKS if none available
          System.out.println("Thread-" + threadId + " acquired connection: " + conn);
          // Simulate DB work
          Thread.sleep(3000);
          connectionPool.returnConnection(conn);
          System.out.println("Thread-" + threadId + " returned connection");
        } catch (Exception e) {
          e.printStackTrace();
        }
      });
    }
    executorService.shutdown();
    executorService.awaitTermination(1, TimeUnit.MINUTES);
    connectionPool.stop();
  }
}
