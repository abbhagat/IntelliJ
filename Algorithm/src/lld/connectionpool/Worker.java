package lld.connectionpool;

import java.sql.Connection;

public class Worker implements Runnable {

  private final ConnectionPool connectionPool;
  private final int threadId;

  public Worker(ConnectionPool connectionPool, int threadId) {
    this.connectionPool = connectionPool;
    this.threadId = threadId;
  }

  @Override
  public void run() {
    try {
      System.out.println(Thread.currentThread().getName() + " trying to get connection...");
      Connection connection = connectionPool.get();  // blocks if none available
      System.out.println(Thread.currentThread().getName() + " acquired connection: " + connection);
      // Simulate DB work
      Thread.sleep(3000);
      connectionPool.put(connection);
      System.out.println("Thread - " + threadId + " returned connection");
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}
