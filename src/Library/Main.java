package Library;

import java.util.List;
import java.util.Scanner;

import Library.dao.BookDao;
import Library.dao.PersonDao;
import Library.dao.TransactionDao;
import Library.models.Book;
import Library.models.Person;
import Library.models.Transaction;
import Library.services.book.BookService;
import Library.services.book.BookServiceImpl;
import Library.services.person.PersonService;
import Library.services.person.PersonServiceImpl;
import Library.services.transaction.TransactionService;
import Library.services.transaction.TransactionServiceImpl;

public class Main {
    static BookDao bookDao = new BookDao();
    static PersonDao personDao = new PersonDao();
    static TransactionDao transactionDao = new TransactionDao();

    static BookService bookService = new BookServiceImpl(bookDao);
    static PersonService personService = new PersonServiceImpl(personDao);
    static TransactionService transactionService = new TransactionServiceImpl(transactionDao);

    private static void mainMenu(){
        System.out.println("""
                === LIBRARY SYSTEM ==
                1. Add & Show All Book
                2. Show All & Select Book
                3. Add & Show All User
                4. Show All & Select User
                5. Rent Book
                6. Return Book
                """);
        System.out.println("Input Pilihan: ");
    }

    // private static void bookMenu(){
    //     System.out.println("""
    //             === BOOK MENU ===
    //             1. Add Book
    //             2. See All Book
    //             3. Search Book
    //             """);
    //     System.out.println("Input Pilihan: ");
    // }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Boolean ulang = true;
        int select;

        try{
            while(ulang){
                mainMenu();
                select = Integer.valueOf(scanner.nextLine());
                
                switch(select){
                    case 1:
                        System.out.println("=== ADD BOOK ===");
                        System.out.println("Book Title: ");
                        String judulBuku = scanner.nextLine();
                        System.out.println("Book Publisher: ");
                        String penerbitBuku = scanner.nextLine();
                        System.out.println("Book Writter: ");
                        String penulisBuku = scanner.nextLine();

                        Book book = new Book(judulBuku, penerbitBuku, penulisBuku);
                        bookService.createBook(book);
                        
                        System.out.println(" ");
                        System.out.println("=== BOOK LIST ===");
                        List<Book> resultsBook = bookService.getAllBook();
                        for (int i = 0; i < resultsBook.size(); i++){
                            System.out.println((i + 1) + ". " + resultsBook.get(i));
                        }
                        break;

                    case 2:
                        System.out.println(" ");
                        System.out.println("=== BOOK LIST ===");
                        List<Book> listBook = bookService.getAllBook();
                        for (int i = 0; i < listBook.size(); i++){
                            System.out.println((i + 1) + ". " + listBook.get(i));
                        }

                        System.out.println(" ");
                        System.out.println("=== SEARCH BOOK ==");
                        System.out.println("Input Books Index: ");
                        Integer pilihBuku = Integer.valueOf(scanner.nextLine());
                        Book hasil = bookService.getBookById(pilihBuku);
                        System.out.println(hasil);
                        break;

                    case 3:
                        System.out.println("=== ADD USER ===");
                        System.out.println("Username: ");
                        String username = scanner.nextLine();
                        System.out.println("Email: ");
                        String email = scanner.nextLine();

                        Person person = new Person(username, email);
                        personService.createPerson(person);

                        System.out.println(" ");
                        System.out.println("=== USER LIST ===");
                        List<Person> resultsPerson = personService.getAllPerson();
                        for (int i = 0; i < resultsPerson.size(); i++){
                            System.out.println((i + 1) + ". " + resultsPerson.get(i));
                        }
                        break;

                    case 4:
                        System.out.println(" ");
                        System.out.println("=== USER LIST ===");
                        List<Person> listPerson = personService.getAllPerson();
                        for (int i = 0; i < listPerson.size(); i++){
                            System.out.println((i + 1) + ". " + listPerson.get(i));
                        }

                        System.out.println(" ");
                        System.out.println("=== SEARCH USER ==");
                        System.out.println("Input User Index: ");
                        Integer pilihUser = Integer.valueOf(scanner.nextLine());
                        Person resultPerson = personService.getPersonById(pilihUser);
                        System.out.println(resultPerson);
                        break;

                    case 5:
                        System.out.println(" ");
                        System.out.println("=== BOOK LIST ===");
                        List<Book> listBorrowed = bookService.getAllBook();
                        for (int i = 0; i < listBorrowed.size(); i++){
                            System.out.println((i + 1) + ". " + listBorrowed.get(i));
                        }

                        System.out.println(" ");
                        System.out.println("=== USER LIST ===");
                        List<Person> listBorrower = personService.getAllPerson();
                        for (int i = 0; i < listBorrower.size(); i++){
                            System.out.println((i + 1) + ". " + listBorrower.get(i));
                        }

                        System.out.println(" ");
                        System.out.println("=== RENT BOOK ===");
                        System.out.println("Input borrower: ");
                        String borrower = scanner.nextLine();
                        System.out.println("Input Book: ");
                        String bookBorrowed = scanner.nextLine();
                        
                        Transaction transaction = new Transaction(borrower, bookBorrowed);
                        transactionService.createBorrow(transaction);

                        System.out.println(" ");
                        System.out.println("=== LIST OF TRANSACTION ===");
                        List<Transaction> resultBorrow = transactionService.getAllTransactions();
                        for (int i = 0; i < resultBorrow.size(); i++){
                            System.out.println((i + 1) + ". " + resultBorrow.get(i));
                        }
                        break;

                    default:
                        System.out.println("Menu tidak tersedia!");
                        // mainMenu();
                        break;
                }

                while (true) {
                    System.out.println("Ingin mengulang Program? (Y | N) ");
                    String again = scanner.nextLine();
                    if("Y".equalsIgnoreCase(again)) {
                        // mainMenu();
                        break;
                    } else if("N".equalsIgnoreCase(again)){
                        ulang = false;
                        break;
                    } else {
                        System.out.println("Input salah");
                        continue;
                    }
                }
            }
        } finally {
        scanner.close();
        }
    }
}
