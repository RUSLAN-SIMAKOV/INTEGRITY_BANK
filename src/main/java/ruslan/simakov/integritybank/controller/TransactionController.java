package ruslan.simakov.integritybank.controller;

import ruslan.simakov.integritybank.exception.TransferException;
import ruslan.simakov.integritybank.model.Transaction;
import ruslan.simakov.integritybank.service.AccountService;
import ruslan.simakov.integritybank.service.TransactionService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TransactionController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(value = "/transfer", method = RequestMethod.GET)
    public String showFormForMoneyTransfer() {
        return "moneyTransfer";
    }

    @Transactional
    @RequestMapping(value = "/moneytransfer", method = RequestMethod.POST)
    public String transferMoney(@RequestParam(name = "transfer_money_from_account") Long transferMoneyFromAccount,
                                @RequestParam(name = "transfer_money_to_account") Long transferMoneyToAccount,
                                @RequestParam(name = "amount_of_money_transferred") Double amountOfMoneyTransferred)
            throws TransferException {
        accountService.transferMoney(transferMoneyFromAccount, -amountOfMoneyTransferred);
        accountService.transferMoney(transferMoneyToAccount, amountOfMoneyTransferred);
        transactionService.addTransaction(transferMoneyFromAccount, transferMoneyToAccount,
                amountOfMoneyTransferred);
        return "redirect:/transfer";
    }

    @RequestMapping(value = "/trans", method = RequestMethod.GET)
    public String getAllTransactions(Model model, @RequestParam(
            value = "page", required = false, defaultValue = "0") Integer page,
                                     @RequestParam(
            value = "limit", required = false, defaultValue = "10") Integer limit,
                                     @RequestParam(
            value = "sort", required = false, defaultValue = "id") String sort,
                                     @RequestParam(
            value = "order", required = false, defaultValue = "asc") String order,
                                     @RequestParam(
            value = "timeAfter", required = false) LocalDateTime timeAfter,
                                     @RequestParam(
            value = "timeBefore", required = false) LocalDateTime timeBefore,
                                     @RequestParam(
            value = "accountId", required = false) Long accountId) {

        Sort.Direction orderDirection = Sort.Direction.fromString(order);
        Sort sortRequest = Sort.by(orderDirection, sort);
        Pageable pageRequest = PageRequest.of(page, limit, sortRequest);
        List<Transaction> listOfTransactions = transactionService.getAllTransactions(pageRequest).toList();
        if (timeAfter != null && timeBefore != null) {
            listOfTransactions = listOfTransactions.stream().filter(t -> t.getTimeOfTransaction().isAfter(timeAfter))
                .filter(t -> t.getTimeOfTransaction().isBefore(timeBefore))
                .collect(Collectors.toList());}
        if (accountId != null) {
            listOfTransactions = listOfTransactions.stream()
                    .filter(t -> t.getTransferMoneyFromAccount().equals(accountId)
                            || t.getTransferMoneyToAccount().equals(accountId))
                    .collect(Collectors.toList());}
        model.addAttribute("transaction", listOfTransactions);
        return "transactions";
    }
}
