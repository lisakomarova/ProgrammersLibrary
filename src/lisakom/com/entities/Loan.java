package lisakom.com.entities;

import lisakom.com.entities.book.Book;
import lisakom.com.entities.reader.Reader;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@ToString
@Data
public class Loan implements Serializable {
    public int idLoan;
    private Book book;
    private Reader reader;
    private LocalDateTime landingDate;
    private LocalDateTime returningDate;
    private static int numberOfLoans = 0;

    @NonNull
    public Loan(@NonNull Book book, @NonNull Reader reader, @NonNull LocalDateTime landingDate){
        numberOfLoans++;
        this.idLoan = numberOfLoans;
        this.book = book;
        this.reader = reader;
        this.landingDate = landingDate;
        this.landingDate = landingDate.plusDays(10);
    }
}
