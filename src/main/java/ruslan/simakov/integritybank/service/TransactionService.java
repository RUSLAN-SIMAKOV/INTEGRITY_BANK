package ruslan.simakov.integritybank.service;

import ruslan.simakov.integritybank.model.Transaction;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TransactionService {

    Page<Transaction> getAllTransactions(Pageable pageable);

    Transaction addTransaction(Long transferMoneyFromAccount, Long transferMoneyToAccount,
                               Double amountOfMoneyTransferred);
}
