package ruslan.simakov.integritybank.service.impl;

import ruslan.simakov.integritybank.model.Account;
import ruslan.simakov.integritybank.repository.AccountRepository;
import ruslan.simakov.integritybank.service.AccountService;
import ruslan.simakov.integritybank.service.ClientService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ClientService clientService;

    @Override
    public List<Account> getClientAccounts(Long id) {
        return clientService.findById(id).getListOfAccounts();
    }

    @Override
    public Account createNewAccount(Account account) {
        return accountRepository.save(account);
    }
}
