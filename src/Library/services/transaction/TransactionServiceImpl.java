package Library.services.transaction;

import java.util.List;

import Library.Exception.EmptyRequestException;
import Library.dao.TransactionDao;
import Library.models.Transaction;

public class TransactionServiceImpl implements TransactionService{
    TransactionDao transactionDao;

    public TransactionServiceImpl(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    @Override
    public void createBorrow(Transaction transaction) {
        if (transaction.getBorrower() ==  " ") {
            throw new EmptyRequestException("Input a valid user");
        } else {
            transactionDao.save(transaction);
            System.out.println("Transaction Added");
        }
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionDao.findAll();
    }

    // @Override
    // public void createReturn(Transaction transaction) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'createReturn'");
    // }

    @Override
    public Transaction geTransactionById(Integer id) {
        return transactionDao.findById(id);
    }
    
}
