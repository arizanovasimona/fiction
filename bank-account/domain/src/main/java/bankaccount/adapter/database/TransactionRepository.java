package bankaccount.adapter.database;

import bankaccount.domain.model.Transaction;
import bankaccount.port.TransactionRepositoryPort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import bankaccount.port.BankAccountRepositoryPort;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long>, TransactionRepositoryPort{

    @Query("FROM Transaction t AND b.id = :id")
    List<Transaction> findAllByBalanceAmountId(@Param("id") Long id);
}

