package Library.services.transaction;

import java.util.List;

import Library.models.Transaction;

public interface TransactionService {
    void createBorrow(Transaction transaction);

    List<Transaction>getAllTransactions();

    //void createReturn(Transaction transaction);

    Transaction geTransactionById(Integer id);
}
