package bankaccount.adapter.database;

import bankaccount.domain.model.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import bankaccount.port.BankAccountRepositoryPort;

import java.util.List;

@Repository
public interface TransactionRepository extends BankAccountRepositoryPort {

    @Override
    @Query ("FROM Transaction t AND b.id = :id")
    List<Transaction> findAllByBalanceAmountId(@Param("id") Long id);

    }

