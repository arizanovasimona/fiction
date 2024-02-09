package bankaccount.port;

import bankaccount.domain.model.BankAccount;
import bankaccount.domain.model.Transaction;

import java.math.BigDecimal;
import java.util.List;

public interface BankAccountPort {

    void deposit(Long bankAccountId, BigDecimal amount) throws Exception;
    boolean withdraw(Long bankAccountId, BigDecimal amount) throws Exception;
    BigDecimal listBalance(Long bankAccountId);
    List<Transaction> listTransactions(Long bankAccountId);
    List<BankAccount> findAll();

}