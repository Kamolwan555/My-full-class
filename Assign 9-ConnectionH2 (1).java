package th.co.cdgs.jbdc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionH2 {
    public Connection getConnectionMem() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:mem:test");
    }
    public Connection getConnectionFile() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:file:~/learning", "learning", "123");
    }

    public Connection getConnectionServer() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/learning", "learning", "123");
    }
}
