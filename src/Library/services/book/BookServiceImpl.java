package Library.services.book;

import java.util.List;

import Library.Exception.EmptyRequestException;
import Library.dao.BookDao;
import Library.models.Book;

public class BookServiceImpl implements BookService {
    BookDao bookDao;

    public BookServiceImpl(BookDao bookDao){
        this.bookDao = bookDao;
    }

    @Override
    public void createBook(Book buku) {
       //validation
       if (buku.getJudul() == " ") {
            //throw exception
            throw new EmptyRequestException("Title cannot be empty");
       } else {
        bookDao.save(buku);
        System.out.println("Book added");
       }
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
