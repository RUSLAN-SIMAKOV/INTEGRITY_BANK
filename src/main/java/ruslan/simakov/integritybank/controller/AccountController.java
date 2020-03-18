package ruslan.simakov.integritybank.controller;

import ruslan.simakov.integritybank.model.Account;
import ruslan.simakov.integritybank.model.Client;
import ruslan.simakov.integritybank.service.AccountService;
import ruslan.simakov.integritybank.service.ClientService;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/clientaccounts", method = RequestMethod.GET)
    public String getAllAccounts(Model model, @RequestParam(name = "client_id") Long id) {

        List<Account> listAccounts = accountService.getClientAccounts(id);
        String clientName = clientService.findById(id).getName();
        model.addAttribute("account", listAccounts);
        model.addAttribute("client_name", clientName);
        model.addAttribute("client_id", id);
        return "accounts";
    }

    @RequestMapping(value = "/addaccount", method = RequestMethod.GET)
    public String addNewAccount(Model model, @RequestParam(name = "client_id") Long id) {
        List<Account> listOfAccount = new ArrayList<>();
        Account account = new Account();
        Client client = clientService.findById(id);
        account.setAmountOfMoney(0.0);
        account.setClient(client);
        account = accountService.createNewAccount(account);
        listOfAccount.add(account);
        String clientName = client.getName();
        model.addAttribute("client_name", clientName);
        model.addAttribute("client_id", id);
        return "accounts";
    }
}
