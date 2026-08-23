package lld.connectionpool;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConnectionPool {
  Connection get()  throws InterruptedException;
  boolean    put(Connection connection);
  void       stop() throws SQLException;
}
