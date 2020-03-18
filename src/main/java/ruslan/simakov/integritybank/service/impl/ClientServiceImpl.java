package ruslan.simakov.integritybank.service.impl;

import ruslan.simakov.integritybank.model.Account;
import ruslan.simakov.integritybank.model.Client;
import ruslan.simakov.integritybank.repository.ClientRepository;
import ruslan.simakov.integritybank.service.AccountService;
import ruslan.simakov.integritybank.service.ClientService;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AccountService accountService;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client addNewClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Can't find client with ID " + id));
    }

    @Override
    public Account addNewAccount(Long id) {

        Account account = new Account();
        Client client = clientRepository.findById(id).get();
        List<Account> listOfAccount = client.getListOfAccounts();
        account.setAmountOfMoney(0.0);
        account.setClient(client);
        account = accountService.createNewAccount(account);
        listOfAccount.add(account);
        client.setListOfAccounts(listOfAccount);
        clientRepository.save(client);
        return account;
    }
}
