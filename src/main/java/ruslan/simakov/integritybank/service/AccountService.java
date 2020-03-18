package ruslan.simakov.integritybank.service;

import ruslan.simakov.integritybank.exception.TransferException;
import ruslan.simakov.integritybank.model.Account;
import java.util.List;

public interface AccountService {

    List<Account> getClientAccounts(Long id);

    Account createNewAccount(Account account);

    void transferMoney(Long accountId, Double amountOfMoney) throws TransferException;
}
