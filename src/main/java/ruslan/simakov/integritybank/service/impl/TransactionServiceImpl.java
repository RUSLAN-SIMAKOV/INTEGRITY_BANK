package ruslan.simakov.integritybank.service.impl;

import ruslan.simakov.integritybank.model.Transaction;
import ruslan.simakov.integritybank.repository.TransactionRepository;
import ruslan.simakov.integritybank.service.TransactionService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

  @Autowired
  private TransactionRepository transactionRepository;

    @Override
    public Page<Transaction> getAllTransactions(Pageable pageable) {
        return transactionRepository.findAll(pageable);
    }

  @Override
  public Transaction addTransaction(Long transferMoneyFromAccount, Long transferMoneyToAccount,
                                    Double amountOfMoneyTransferred) {
      Transaction transaction = new Transaction();
      transaction.setTimeOfTransaction(LocalDateTime.now());
      transaction.setAmountOfMoneyTransferred(amountOfMoneyTransferred);
      transaction.setTransferMoneyFromAccount(transferMoneyFromAccount);
      transaction.setTransferMoneyToAccount(transferMoneyToAccount);
    return transactionRepository.save(transaction);
  }
}
