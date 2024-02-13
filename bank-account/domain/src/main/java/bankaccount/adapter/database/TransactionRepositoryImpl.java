package bankaccount.adapter.database;

import bankaccount.domain.model.Transaction;
import bankaccount.port.TransactionRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class TransactionRepositoryImpl implements TransactionRepositoryPort {

    @Autowired
    TransactionRepository repository;

    public List<Transaction> findAllByBalanceAmountId(Long id) {
        return repository.findAllByBalanceAmountId(id);
    }

}
