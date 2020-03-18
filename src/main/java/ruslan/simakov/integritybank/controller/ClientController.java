package ruslan.simakov.integritybank.controller;

import ruslan.simakov.integritybank.model.Client;
import ruslan.simakov.integritybank.service.ClientService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public String getAllClients(Model model) {

        List<Client> listOfClients = clientService.getAllClients();
        model.addAttribute("client", listOfClients);
        return "clients";
    }

    @RequestMapping(value = "/addClient", method = RequestMethod.POST)
    public String addNewClient(@RequestParam(name = "client_name") String name,
                               @RequestParam(name = "client_age") Byte age,
                               @RequestParam(name = "client_address") String address) {
        Client client = new Client();
        client.setName(name);
        client.setAge(age);
        client.setAddress(address);
        clientService.addNewClient(client);
        return "redirect:/clients";
    }
}
