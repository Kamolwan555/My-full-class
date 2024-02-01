package th.co.cdgs.atm;

import java.math.BigDecimal;

public class BankAccount {

    private String accountName;
    private BigDecimal money;

    public BankAccount(String accountName) {
        this.accountName = accountName;
        this.money = BigDecimal.ZERO;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public String getAccountName() {
        return accountName;
    }
}
