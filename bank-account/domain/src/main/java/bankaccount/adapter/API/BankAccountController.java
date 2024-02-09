package bankaccount.adapter.API;

import bankaccount.config.WebConfiguration;
import bankaccount.domain.model.BankAccount;
import bankaccount.domain.model.Transaction;
import bankaccount.port.BankAccountPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@ComponentScan(basePackageClasses = WebConfiguration.class)
//@RequestMapping(value = "/bankAccount")
public class BankAccountController {

    @Autowired
    @Qualifier("bankAccountPort")
    private BankAccountPort bankAccountPort;

    /**
     * @return List of transactions for specific account
     */

    @GetMapping("/test")
    String test(){
        return "Vrai!";
    }

    @GetMapping("/find")
    List<BankAccount> findAll(){
        return bankAccountPort.findAll();
    }

    @GetMapping("/transactions/{bankAccountId}")
    List<Transaction> listTransactions(Long id) {
        return bankAccountPort.listTransactions(id);
    }

    /**
     * @return List balance for specific account
     */
    @GetMapping("/balance/{bankAccountId}")
    BigDecimal listBalance(Long id) {
        return bankAccountPort.listBalance(id);
    }

    /**
     * @param bankAccountId
     * @param amount
     * @return Deposits amount in bankAccountId
     * @throws Exception
     */
    @PostMapping("/deposit/{bankAccountId}/{amount}")
    public ResponseEntity deposit(@PathVariable("bankAccountId") Long bankAccountId, @PathVariable("amount") BigDecimal amount) throws Exception {
        bankAccountPort.deposit(bankAccountId,amount);
        return ResponseEntity.noContent().build();
    }

    /**
     * @param bankAccountId
     * @param amount
     * @return Withdraws amount from bankAccountId if available
     * If insufficient funds, displays a compassionate message
     * @throws Exception
     */
    @PostMapping("/withdraw/{bankAccountId}/{amount}")
    public ResponseEntity withdraw(@PathVariable("bankAccountId") Long bankAccountId, @PathVariable("amount") BigDecimal amount) throws Exception {
        bankAccountPort.withdraw(bankAccountId,amount);
        return ResponseEntity.noContent().build();
    }
}