package lisakom.com.entities.book;

import lisakom.com.entities.Picture;
import lisakom.com.enumerations.BookStatus;
import lisakom.com.enumerations.Genre;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@EqualsAndHashCode
@ToString
@Data
public class Book implements Serializable {
    private int idBook;
    private String title;
    private Genre genre;
    private int publicationYear;
    private ArrayList<Author> authors;
    private LocalDate publicationDate;
    private Publisher publisher;
    private int numberOfCopies;
    private ArrayList<Picture> coverPictures;
    private BookStatus bookStatus;
    private static int bumberOfBooks = 0;

    public Book(@NonNull String title, Genre genre, int publicationYear, ArrayList<Author> authors, Publisher publisher,
                int numberOfCopies, ArrayList<Picture> coverPictures, BookStatus bookStatus){
        if((publicationYear < 1900) & (publicationYear > Calendar.getInstance().get(Calendar.YEAR)))
            throw new IllegalArgumentException();
        bumberOfBooks++;
        idBook = bumberOfBooks;
        this.title = title;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.authors = authors;
        this.publisher = publisher;
        this.numberOfCopies = numberOfCopies;
        this.coverPictures = coverPictures;
        this.bookStatus = bookStatus;
    }

    public void incrementNumberOfCopies(){
        numberOfCopies++;
    }
    public void decrementNumberOfCopies(){
        numberOfCopies--;
    }
}
