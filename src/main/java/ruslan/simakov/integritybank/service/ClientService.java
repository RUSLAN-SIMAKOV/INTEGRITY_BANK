package ruslan.simakov.integritybank.service;

import ruslan.simakov.integritybank.model.Account;
import ruslan.simakov.integritybank.model.Client;
import java.util.List;

public interface ClientService {

    List<Client> getAllClients();

    Client addNewClient(Client client);

    Client findById(Long id);

    Account addNewAccount(Long id);
}
