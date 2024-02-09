package bankaccount.domain.model;

import java.math.BigDecimal;
import java.util.List;

public class BankAccount {

    private Long id;
    private BigDecimal balance;
    private List<Transaction> transactionList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    /**
     * Checks if user can withdraw from his bank account given no overdraft autorization (potato bank)
     * @param amount : desired amount to withdraw
     * @return If user has enough in this bank account to withdraw provided amount -> true, else false
     */

    public boolean withdraw(BigDecimal amount) {
        if(balance.compareTo(amount) < 0) {
            return false;
        }

        balance = balance.subtract(amount);
        return true;
    }

    /**
     * Deposits amount to bank account
     * @param amount : desired amount to deposit
     */

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    /**
     * @return List of transaction for specific bank account
     */

    public List<Transaction> listTransaction() {
        return transactionList;
    }

    /**
     * @return Balance of specific bank account
     */

    public BigDecimal listBalance() {
        return balance;
    }

}