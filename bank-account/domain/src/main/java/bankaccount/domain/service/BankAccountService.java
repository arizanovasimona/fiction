package bankaccount.domain.service;

import bankaccount.adapter.database.BankAccountRepositoryImpl;
import bankaccount.domain.model.BankAccount;
import bankaccount.domain.model.Transaction;
import bankaccount.port.BankAccountPort;
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
    BankAccountRepositoryImpl bankAccountRepository;

    /*@Autowired
    @Qualifier("bankAccountRepositoryPort")
    TransactionRepositoryImpl transactionRepository;*/

    @Override
    @Transactional
    public void deposit(Long bankAccountId, BigDecimal amount) throws Exception {
        BankAccount bankAccount2 = bankAccountRepository.findById(bankAccountId)
                .orElseThrow(() -> new Exception(" "/*CustomerConstant.CUSTOMER_NOT_FOUND + id*/));
        bankAccount2.setBalance(bankAccount2.getBalance().add(amount));
        bankAccountRepository.save(bankAccount2);
    }

    @Override
    @Transactional
    public boolean withdraw(Long bankAccountId, BigDecimal amount) throws Exception {
        if(bankAccountRepository.findBalance(bankAccountId).compareTo(amount) >0) {
            BankAccount bankAccount2 = bankAccountRepository.findById(bankAccountId)
                    .orElseThrow(() -> new Exception(" "/*CustomerConstant.CUSTOMER_NOT_FOUND + id*/));
            bankAccount2.setBalance(bankAccount2.getBalance().subtract(amount));
            bankAccountRepository.save(bankAccount2);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public BigDecimal listBalance(Long bankAccountId) {
        return bankAccountRepository.findBalance(bankAccountId);
    }


    @Override
    public List<Transaction> listTransactions(Long bankAccountId) {
        return null;//bankAccountRepository.findAllByBalanceAmountId(bankAccountId);
    }

    @Override
    public List<BankAccount> findAll() {
        return bankAccountRepository.findAll();
    }
}