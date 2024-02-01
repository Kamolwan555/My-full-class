package th.co.cdgs.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:mem:test");
    }

    public String login(String userId, String password) throws SQLException {
        String sql = "SELECT NAME FROM USER_ACCOUNT WHERE USER_ID = ? AND PASSWORD = ?";
        try (Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, userId);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery();) {
                if(rs.next()) {
                    return rs.getString("NAME");
                }
            }
        }
        return null;
    }
}
