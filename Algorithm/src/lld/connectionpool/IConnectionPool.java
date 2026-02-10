package lld.connectionpool;

import java.sql.Connection;
import java.sql.SQLException;

interface IConnectionPool {
  Connection getConnection() throws InterruptedException;
  boolean returnConnection(Connection connection);
  void stop() throws SQLException;
}
