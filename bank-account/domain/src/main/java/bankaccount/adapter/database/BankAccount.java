package bankaccount.adapter.database;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "BANKACCOUNT")
public class BankAccount implements Serializable {

    @Id
    @Column (name = "bankaccount_id")
    private Long id;

    @Column
    private BigDecimal balance;

}
