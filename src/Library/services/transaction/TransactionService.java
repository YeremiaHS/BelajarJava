package Library.services.transaction;

import java.util.List;

import Library.models.Transaction;

public interface TransactionService {
    void createBorrow(Integer idBorrower, Integer idBorrowedBook);

    List<Transaction>getAllTransactions();

    void createReturn(Integer kembali);

    Transaction geTransactionById(Integer id);
}
