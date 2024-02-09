package bankaccount.adapter.API;

import bankaccount.domain.model.Transaction;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.List;

@Entity
class BankAccountResponse {

    private final Long id;
    private final BigDecimal balance;
    private final List<Transaction> transactionList;

    private BankAccountResponse(Long id, BigDecimal balance, List<Transaction> transactionList) {
        this.id = id;
        this.balance = balance;
        this.transactionList = transactionList;
    }

}
