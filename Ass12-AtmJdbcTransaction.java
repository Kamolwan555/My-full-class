package th.co.cdgs.atm;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AtmJdbcTransaction {
    
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:mem:test");
    }

    public BankAccount getAccount(String accountName) throws SQLException {
        BankAccount account = null;
        try(Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(
                    " SELECT ACCOUNT_NAME, MONEY FROM BANK_ACCOUNT WHERE ACCOUNT_NAME = ?")) {
            ps.setString(1, accountName);
            try(ResultSet rs = ps.executeQuery();) {
                if(rs.next()) {
                    account = new BankAccount(rs.getString("ACCOUNT_NAME"));
                    account.setMoney(rs.getBigDecimal("MONEY"));
                }
            }
        }
        return account;
    }

    public void transfer(BankAccount source, BankAccount destination) throws SQLException {
        Connection conn = getConnection();
        try {
            conn.setAutoCommit(false);

            BigDecimal money = withdraw(null, source.getAccountName(), source.getMoney());
            deposit(null, destination.getAccountName(), money);

            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            throw e;
        } finally {
            conn.setAutoCommit(true);
            conn.close();
        }
    }

    public BigDecimal withdraw(Connection conn, String accountName, BigDecimal money) throws SQLException {
        BankAccount account = getAccount(accountName);
        if (BigDecimal.ZERO.compareTo(account.getMoney().subtract(money)) > 0) {
            throw new RuntimeException("Not enough money");
        }
        String sql = "UPDATE BANK_ACCOUNT SET MONEY = ? WHERE ACCOUNT_NAME = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setBigDecimal(1, account.getMoney().subtract(money));
            ps.setString(2, accountName);
            ps.executeUpdate();
        }
        return money;
    }

    public void deposit(Connection conn, String accountName, BigDecimal money) throws SQLException {
        BankAccount account = getAccount(accountName);
        String sql = " UPDATE BANK_ACCOUNT SET MONEY = ? WHERE ACCOUNT_NAME = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setBigDecimal(1, account.getMoney().add(money));
            ps.setString(2, accountName);
            ps.executeUpdate();
        }
    }
}
