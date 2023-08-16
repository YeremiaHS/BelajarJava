package Library.dao;

import java.util.ArrayList;
import java.util.List;

import Library.models.Transaction;
import Library.services.BaseDao;

public class TransactionDao implements BaseDao<Transaction, Integer> {

    List<Transaction> transaction = new ArrayList<>();

    @Override
    public void save(Transaction data) {
        transaction.add(data);
    }

    @Override
    public List<Transaction> findAll() {
        return this.transaction;
    }

    @Override
    public Transaction findById(Integer id) {
        return  this.transaction.get(id - 1);
    }

    @Override
    public void update(Integer id, Transaction data) {
        transaction.set(id - 1, data);
    }

    @Override
    public void delete(Integer id) {
        transaction.remove(id - 1);
    }
    
}
