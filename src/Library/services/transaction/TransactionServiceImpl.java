package Library.services.transaction;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        if (idBorrower <= 0 || idBorrower > getAllPerson().size()) {
            throw new BadRequestException("ID Invalid");
        } if (idBookBorrowed <= 0 || idBookBorrowed > getAllBook().size()) {
            throw new BadRequestException("ID Invalid");
        }
        String peminjam = getPersonById(idBorrower).toString();
        String bukuDipinjam = getBookById(idBookBorrowed).toString();
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
        if (kembali <=0 || kembali > getAllTransactions().size()) {
            throw new BadRequestException("Input valid id");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMM uuuu HH:mm");
        LocalDateTime dateNow = LocalDateTime.now();
        String dateReturn = dateNow.format(formatter);
        Transaction dataTransaction = transactionDao.findById(kembali);
        dataTransaction.setDateReturn(dateReturn.toString());
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
        return personDao.findAll();
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
        return bookDao.findAll();
    }

    @Override
    public Book getBookById(Integer id) {
        return bookDao.findById(id);
    }
    
}
