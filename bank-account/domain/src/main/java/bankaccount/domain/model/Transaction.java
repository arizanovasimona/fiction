package bankaccount.domain.model;

import java.math.BigDecimal;

public class Transaction {

    private BigDecimal amount;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}