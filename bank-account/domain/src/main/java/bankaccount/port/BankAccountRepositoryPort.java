package bankaccount.port;

import bankaccount.domain.model.BankAccount;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface BankAccountRepositoryPort {

    BigDecimal findBalance(Long id);
    List<BankAccount> findAll();
    Optional<BankAccount> findById(Long id);
}
