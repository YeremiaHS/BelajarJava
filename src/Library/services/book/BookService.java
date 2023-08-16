package Library.services.book;

import java.util.List;

import Library.models.Book;

public interface BookService {
    void createBook(Book buku);

    List<Book> getAllBook();

    Book getBookById(Integer id);
}
