package Library.services.book;

import java.util.List;

import Library.Exception.BadRequestException;
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
       if (buku.getJudul().isEmpty()) {
            //throw exception
            throw new BadRequestException("Field cannot be empty");
       } if (buku.getPenerbit().isEmpty()) {
            throw new BadRequestException("Field cannot be empty");
       } if (buku.getPengarang().isEmpty()) {
            throw new BadRequestException("Field cannot be empty");
       }else {
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
        if (id <=0 || id > getAllBook().size() ) {
            throw new BadRequestException("Input valid id");
        }
        return bookDao.findById(id);
    }

}
