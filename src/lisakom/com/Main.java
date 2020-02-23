package lisakom.com;

import lisakom.com.entities.Loan;
import lisakom.com.entities.book.Author;
import lisakom.com.entities.book.Book;
import lisakom.com.entities.reader.Reader;
import lisakom.com.enumerations.Gender;
import lisakom.com.enumerations.Genre;
import lisakom.com.exceptions.BookIsNotAvailableException;
import lisakom.com.exceptions.ReaderAlreadyHasBookException;
import lisakom.com.utils.FileHelper;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.InvalidObjectException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws BookIsNotAvailableException, ReaderAlreadyHasBookException {

        Logger logger = LogManager.getLogger(Main.class);
        BasicConfigurator.configure();

        File fileBooks = new File("books.data");
        File fileReaders = new File("readers.data");
        File fileLoans = new File("loans.data");

        LibraryManager manager = new LibraryManager();
        logger.info("Library manager object is created");

        try {
            if(fileBooks.exists()) manager.books = FileHelper.readFile(fileBooks);
            logger.info("data is read from file fileBooks");
            if(fileReaders.exists()) manager.readers = FileHelper.readFile(fileReaders);
            logger.info("data is read from file fileReaders");
            if(fileLoans.exists()) manager.loans = FileHelper.readFile(fileLoans);
            logger.info("data is read from file fileLoans");
            for (Book b: manager.books){
                logger.info(b.toString());
            }
            for (Reader r: manager.readers){
                logger.info(r.toString());
            }
            for (Loan l: manager.loans){
                logger.info(l.toString());
            }
        }
        catch (InvalidObjectException e) {
            logger.error(e.getCause());
            e.printStackTrace();
        }

        logger.info(manager.books.get(0).getBookStatus());

        for (Book b: manager.books){
            logger.info(b.getNumberOfCopies());
        }

        manager.returnBook(manager.books.get(1), manager.readers.get(1));
        logger.info("book returned");
        manager.returnBook(manager.books.get(2),manager.readers.get(2));
        logger.info("book returned");
        logger.info(manager.readers.get(1).isHasBook());
        logger.info(manager.readers.get(0).isHasBook());
        manager.issueBook(manager.books.get(2),manager.readers.get(1));
        logger.info("book issued");
        //1,2 readers yes, 3 reader no
        for (Reader reader: manager.readers){
            logger.info(reader.isHasBook());
        }

        logger.info("number of issued books: " + manager.countIssuedBooks());

        ArrayList<Book> foundBooksByTitle = manager.findBookByTitle("HeadFirst Java");
        logger.info("search of books by title is completed");
        for (Book b: foundBooksByTitle
             ) {
            logger.info(b);
        }

        Author AndrewStellman = new Author(" Andrew", " Stellman", null, Gender.MALE,null);
        logger.info("author object is created" + AndrewStellman.getFirstName() + AndrewStellman.getLastName());

        ArrayList<Book> foundBooksByAuthor = manager.findBookByAuthor(AndrewStellman);
        logger.info("search of books by author is completed");
        for (Book b: foundBooksByAuthor
        ) {
            logger.info(b);
        }

        ArrayList<Book> foundBooksByGenre = manager.findBookByGenre(Genre.JAVA);
        logger.info("search of books by genre is completed");
        for (Book b: foundBooksByGenre
        ) {
            logger.info(b);
        }

        ArrayList<Book> foundBooksByYear = manager.findBookByYear(2013);
        logger.info("search of books by year is completed");
        for (Book b: foundBooksByYear
        ) {
            logger.info(b);
        }
    }
}
