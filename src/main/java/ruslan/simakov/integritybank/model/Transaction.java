package ruslan.simakov.integritybank.model;


import lombok.Data;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime timeOfTransaction;
    private Long transferMoneyFromAccount;
    private Long transferMoneyToAccount;
    private Double amountOfMoneyTransferred;
}
