package bankaccount.port;

import bankaccount.domain.model.BankAccount;
import bankaccount.domain.model.Transaction;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface TransactionRepositoryPort {

    List<Transaction> findAllByBalanceAmountId(Long id);

}
