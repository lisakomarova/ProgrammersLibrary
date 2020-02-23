package lisakom.com.entities.reader;

import lisakom.com.entities.Picture;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@ToString
public class IdentificationCard implements Serializable {
    private int idIdentificationCard;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String organisation;
    public  String email;
    private String phoneNumber;
    private Picture picture;
    private static int numberOfCards = 0;

    public IdentificationCard(@NonNull String firstName, @NonNull String lastName, LocalDate birthday,
                              String organisation, @NonNull String email, String phoneNumber, Picture picture){
        if (!(phoneNumber.matches("^(?=(?:[8-9]){1})(?=[0-9]{8}).*"))) {
            throw new IllegalArgumentException();
        }
        numberOfCards++;
        this.idIdentificationCard = numberOfCards;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.organisation = organisation;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.picture = picture;

    }

}
