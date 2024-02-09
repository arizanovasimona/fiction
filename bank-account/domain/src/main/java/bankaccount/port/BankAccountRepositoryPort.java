package bankaccount.port;

import bankaccount.domain.model.BankAccount;
import bankaccount.domain.model.Transaction;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface BankAccountRepositoryPort {

    BigDecimal findBalance(Long id);
    List<Transaction> findAllByBalanceAmountId(Long id);
    List<BankAccount> findAll();
    Optional<BankAccount> findById(Long id);
    void save(BankAccount bankAccount);

}
