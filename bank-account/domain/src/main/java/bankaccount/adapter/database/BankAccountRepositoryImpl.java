package bankaccount.adapter.database;

import bankaccount.domain.model.BankAccount;
import bankaccount.domain.model.Transaction;
import bankaccount.port.BankAccountRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
public class BankAccountRepositoryImpl implements BankAccountRepository {

    @Autowired
    BankAccountRepository repository;

    @Override
    public BigDecimal findBalance(Long id) {
        return repository.findBalance(id);
    }

    @Override
    public List<Transaction> findAllByBalanceAmountId(Long id) {
        return repository.findAllByBalanceAmountId(id);
    }

    @Override
    public List<BankAccount> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<BankAccount> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(BankAccount bankAccount) {
        repository.save(bankAccount);
    }
}
