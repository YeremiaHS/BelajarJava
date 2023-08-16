package Library.models;

import java.time.LocalDate;

public class Transaction {
    
    Person person = new Person();
    Book book = new Book();

    LocalDate dateNow = LocalDate.now();
    private String dateBorrow = dateNow.toString();
    //private String dateReturn = dateNow.toString();
    private String borrower = person.getUsername();
    private String bookBorrowed = book.getJudul(); 


    public Transaction(){

    }

    public Transaction(String dateBorrow, String borrower, String bookBorrowed){
        //this.dateReturn = dateReturn;
        this.dateBorrow = dateBorrow;
        this.borrower = borrower;
        this.bookBorrowed = bookBorrowed;
    }
    

    // public LocalDate getDateNow() {
    //     return dateNow;
    // }

    // public void setDateNow(LocalDate dateNow) {
    //     this.dateNow = dateNow;
    // }

    public Transaction(Integer idBorrower, Integer idBook) {
    }

    public String getDateBorrow() {
        return dateBorrow;
    }

    public void setDateBorrow(String dateBorrow) {
        this.dateBorrow = dateBorrow;
    }

    // public String getDateReturn() {
    //     return dateReturn;
    // }

    // public void setDateReturn(String dateReturn) {
    //     this.dateReturn = dateReturn;
    // }

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
        return "Transaction [dateBorrow=" + dateBorrow + ", borrower=" + borrower + ", bookBorrowed=" + bookBorrowed
                + "]";
    }
    
    
    
}