
package no.priv.garshol.duke;

import java.util.Properties;
import java.sql.Driver;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCUtils {

  public static Statement open(String driverklass, String jdbcuri, Properties props) {
    try {
      Class driverclass = Class.forName(driverklass);
      Driver driver = (Driver) driverclass.newInstance();
      Connection conn = driver.connect(jdbcuri, props);
      if (conn == null)
        throw new RuntimeException("Couldn't connect to database at " + jdbcuri);
      return conn.createStatement();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    } catch (InstantiationException e) {
      throw new RuntimeException(e);
    } catch (IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }
  
}