package ruslan.simakov.integritybank.service.impl;

import ruslan.simakov.integritybank.model.Client;
import ruslan.simakov.integritybank.repository.ClientRepository;
import ruslan.simakov.integritybank.service.ClientService;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public Client addNewClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Can't find client!!!"));
    }
}
