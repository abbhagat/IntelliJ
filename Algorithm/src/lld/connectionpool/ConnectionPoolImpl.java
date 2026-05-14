package lld.connectionpool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionPoolImpl {

  public static void main(String[] args) throws SQLException, InterruptedException {
    ConnectionPool connectionPool = new ConnectionPool(5);
    AtomicInteger atomicInteger = new AtomicInteger(1);
    connectionPool.getConnectionPool().forEach(connection -> {
      System.out.println("DB Connection " + atomicInteger.getAndIncrement() + " " + connection);
    });
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    for (int i = 1; i <= 10; i++) {
      int threadId = i;
      executorService.submit(() -> {
        try {
          System.out.println("Thread-" + threadId + " trying to get connection...");
          Connection conn = connectionPool.get();  // BLOCKS if none available
          System.out.println("Thread-" + threadId + " acquired connection: " + conn);
          // Simulate DB work
          Thread.sleep(3000);
          connectionPool.put(conn);
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
