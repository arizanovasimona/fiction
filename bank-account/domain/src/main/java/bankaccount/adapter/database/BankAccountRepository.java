package bankaccount.adapter.database;

import bankaccount.domain.model.BankAccount;
import bankaccount.port.BankAccountRepositoryPort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount,Long>,BankAccountRepositoryPort {

    @Query ("SELECT b.balance FROM BankAccount b" +
            "WHERE b.id = :id")
    BigDecimal findBalance(@Param("id") Long id);

    Optional<BankAccount> findById(Long id);

}
