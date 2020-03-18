package ruslan.simakov.integritybank.service;

import ruslan.simakov.integritybank.model.Account;
import java.util.List;

public interface AccountService {

    List<Account> getClientAccounts(Long id);

    Account createNewAccount(Account account);
}
