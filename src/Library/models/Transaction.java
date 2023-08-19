package Library.models;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    
    //Person person = new Person();
    //Book book = new Book();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMM uuuu HH:mm");
    LocalDateTime dateNow = LocalDateTime.now();
    //String dateFormat = dateNow.format(formatter);
    private String dateBorrow = dateNow.format(formatter).toString();
    private String dateReturn = " Not returned";/*dateNow.format(formatter).toString();*/
    private String borrower;
    private String bookBorrowed; 


    public Transaction(String borrower, String bookBorrowed){
        this.borrower = borrower;
        this.bookBorrowed = bookBorrowed;
    }

    // public Transaction(String dateBorrow, String borrower, String bookBorrowed){
    //     //this.dateReturn = dateReturn;
    //     this.dateBorrow = dateBorrow;
    //     this.borrower = borrower;
    //     this.bookBorrowed = bookBorrowed;
    // }

    public String getDateBorrow() {
        return dateBorrow;
    }

    public void setDateBorrow(String dateBorrow) {
        this.dateBorrow = dateBorrow;
    }

    public String getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(String dateReturn) {
        this.dateReturn = dateReturn;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public String getBookBorrowed() {
        return bookBorrowed;
    }

    public void setBookBorrowed(String bookBorrowed) {
        this.bookBorrowed = bookBorrowed;
    }

    @Override
    public String toString() {
        return "Transaction [Date Borrow= " + dateBorrow + " | Date Return= " + dateReturn + " | Borrower= " + borrower
                + " | Book Borrowed= " + bookBorrowed + "]";
    }
    
    
    
}
