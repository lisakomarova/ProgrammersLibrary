package lisakom.com;

import lisakom.com.entities.book.Author;
import lisakom.com.entities.book.Book;
import lisakom.com.entities.Loan;
import lisakom.com.entities.reader.Reader;
import lisakom.com.enumerations.BookStatus;
import lisakom.com.enumerations.Genre;
import lisakom.com.exceptions.BookIsNotAvailableException;
import lisakom.com.exceptions.ReaderAlreadyHasBookException;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;

public class LibraryManager{
    public static ArrayList<Book> books;
    public static ArrayList<Reader> readers;
    public static ArrayList<Loan> loans;

    public LibraryManager(){
        books = new ArrayList<>();
        readers = new ArrayList<>();
        loans = new ArrayList<>();
    }
    public void issueBook(@NonNull Book book, @NonNull Reader reader) throws BookIsNotAvailableException,
            ReaderAlreadyHasBookException {
        if((book.getBookStatus()==BookStatus.LOANED || book.getBookStatus()==BookStatus.DISPOSED) && book.getNumberOfCopies() == 0)
            throw new BookIsNotAvailableException("book is not available");
        if(reader.isHasBook())
            throw new ReaderAlreadyHasBookException("the reader already has one book on hand");
        Loan loan = new Loan(book, reader, LocalDateTime.now());
        reader.setHasBook(true);
        book.decrementNumberOfCopies();
        if (book.getNumberOfCopies()==0){
            book.setBookStatus(BookStatus.LOANED);
        }
        loans.add(loan);
    }

    public void returnBook(@NonNull Book book, @NonNull Reader reader){
        int loanID = 0;
        for (Loan loan: loans
             ) {
            if(loan.getReader().equals(reader)){
                if(loan.getBook().equals(book))
                    loanID = loans.indexOf(loan);
            };
        }
        loans.remove(loanID);
        book.incrementNumberOfCopies();
        book.setBookStatus(BookStatus.AVAILABLE);
        reader.setHasBook(false);
    }
    public int countIssuedBooks(){
        return loans.size();
    }
    public ArrayList<Book> findBookByTitle(@NonNull String title) {
        ArrayList<Book> foundBooks = new ArrayList<>();
        for (Book book: books) {
            if(book.getTitle().equals(title))
                foundBooks.add(book);
        }
        return foundBooks;
    }
    public ArrayList<Book> findBookByAuthor(@NonNull Author author){
        ArrayList<Book> foundBooks = new ArrayList<>();
        for (Book book: books) {
            if(book.getAuthors().contains(author))
                foundBooks.add(book);
        }
        return foundBooks;
    }
    public ArrayList<Book> findBookByGenre(@NonNull Genre genre){
        ArrayList<Book> foundBooks = new ArrayList<>();
        for (Book book: books) {
            if(book.getGenre().equals(genre))
                foundBooks.add(book);
        }
        return foundBooks;
    }
    public ArrayList<Book> findBookByYear(int year) {
        if((year < 1900) & (year > Calendar.getInstance().get(Calendar.YEAR)))
            throw new IllegalArgumentException();
        ArrayList<Book> foundBooks = new ArrayList<>();
        for (Book book: books) {
            if(book.getPublicationYear() == year)
                foundBooks.add(book);
        }
        return foundBooks;
    }
}
