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
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    for (int i = 1; i <= 10; i++) {
      Runnable task = new Worker(connectionPool, i);
      executorService.submit(task);
    }
    executorService.shutdown();
    // Blocks until all tasks have completed execution after a shutdown request, or the timeout occurs, or the current thread is interrupted, whichever happens first.
    executorService.awaitTermination(1, TimeUnit.MINUTES);
    connectionPool.stop();
  }
}
