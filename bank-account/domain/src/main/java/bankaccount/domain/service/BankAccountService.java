package bankaccount.domain.service;

import bankaccount.adapter.database.BankAccountRepository;
import bankaccount.adapter.database.BankAccountRepositoryImpl;
import bankaccount.domain.model.BankAccount;
import bankaccount.domain.model.Transaction;
import bankaccount.port.BankAccountPort;
import bankaccount.port.BankAccountRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
public class BankAccountService implements BankAccountPort {

    @Autowired
    @Qualifier("bankAccountRepositoryPort")
    BankAccountRepositoryImpl repositoryPort;

    @Override
    @Transactional
    public void deposit(Long bankAccountId, BigDecimal amount) throws Exception {
        BankAccount bankAccount2 = repositoryPort.findById(bankAccountId)
                .orElseThrow(() -> new Exception(" "/*CustomerConstant.CUSTOMER_NOT_FOUND + id*/));
        bankAccount2.setBalance(bankAccount2.getBalance().add(amount));
        repositoryPort.save(bankAccount2);
    }

    @Override
    @Transactional
    public boolean withdraw(Long bankAccountId, BigDecimal amount) throws Exception {
        if(repositoryPort.findBalance(bankAccountId).compareTo(amount) >0) {
            BankAccount bankAccount2 = repositoryPort.findById(bankAccountId)
                    .orElseThrow(() -> new Exception(" "/*CustomerConstant.CUSTOMER_NOT_FOUND + id*/));
            bankAccount2.setBalance(bankAccount2.getBalance().subtract(amount));
            repositoryPort.save(bankAccount2);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public BigDecimal listBalance(Long bankAccountId) {
        return repositoryPort.findBalance(bankAccountId);
    }


    @Override
    public List<Transaction> listTransactions(Long bankAccountId) {
        return repositoryPort.findAllByBalanceAmountId(bankAccountId);
    }

    @Override
    public List<BankAccount> findAll() {
        return repositoryPort.findAll();
    }
}