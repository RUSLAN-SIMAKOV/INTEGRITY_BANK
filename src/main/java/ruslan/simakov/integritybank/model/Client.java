package ruslan.simakov.integritybank.model;

import lombok.Data;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Byte age;
    private String name;
    private String address;
    @OneToMany
    private List<Account> listOfAccounts;
}
