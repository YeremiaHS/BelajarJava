package Library.services.transaction;

import java.time.LocalDateTime;
import java.util.List;

import Library.Exception.BadRequestException;
//import Library.Exception.EmptyRequestException;
import Library.dao.BookDao;
import Library.dao.PersonDao;
import Library.dao.TransactionDao;
import Library.models.Book;
import Library.models.Person;
import Library.models.Transaction;
import Library.services.book.BookService;
import Library.services.person.PersonService;

public class TransactionServiceImpl implements TransactionService, BookService, PersonService{
    TransactionDao transactionDao;
    PersonDao personDao;
    BookDao bookDao;

    public TransactionServiceImpl(TransactionDao transactionDao, BookDao bookDao, PersonDao personDao) {
        this.transactionDao = transactionDao;
        this.bookDao = bookDao;
        this.personDao = personDao;
    }

    @Override
    public void createBorrow(Integer idBorrower, Integer idBookBorrowed ) {
        if (idBorrower <= 0) {
            throw new BadRequestException("ID Invalid");
        } else if (idBookBorrowed <= 0) {
            throw new BadRequestException("ID Invalid");
        }
        String peminjam = getBookById(idBorrower).toString();
        String bukuDipinjam = getPersonById(idBookBorrowed).toString();
        Transaction transaction = new Transaction(peminjam, bukuDipinjam);
        transactionDao.save(transaction);
        System.out.println("Borrow success!");
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionDao.findAll();
    }

    @Override
    public void createReturn(Integer kembali) {
        if (kembali <=0) {
            throw new BadRequestException("Input valid id");
        }
        LocalDateTime dateNow = LocalDateTime.now();
        Transaction dataTransaction = transactionDao.findById(kembali);
        dataTransaction.setDateReturn(dateNow.toString());
        transactionDao.update(kembali, dataTransaction);
        System.out.println("Return success!");
    }

    @Override
    public Transaction geTransactionById(Integer id) {
        return transactionDao.findById(id);
    }

    @Override
    public void createPerson(Person person) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createPerson'");
    }

    @Override
    public List<Person> getAllPerson() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllPerson'");
    }

    @Override
    public Person getPersonById(Integer id) {
        return personDao.findById(id);
    }

    @Override
    public void createBook(Book buku) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createBook'");
    }

    @Override
    public List<Book> getAllBook() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllBook'");
    }

    @Override
    public Book getBookById(Integer id) {
        return bookDao.findById(id);
    }
    
}
