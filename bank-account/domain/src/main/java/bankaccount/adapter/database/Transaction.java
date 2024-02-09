package bankaccount.adapter.database;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "TRANSACTION")
public class Transaction implements Serializable {

    @Id
    @GeneratedValue( strategy=GenerationType.IDENTITY )
    @Column (name = "transaction_id")
    private Long id;

    @Column
    private BigDecimal amount;

    @JoinColumn (name = "bankaccount_id")
    @ManyToOne (cascade = CascadeType.ALL )
    private List<BankAccount> bankAccounts;
}
