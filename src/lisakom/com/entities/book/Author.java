package lisakom.com.entities.book;

import lisakom.com.enumerations.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author implements Serializable {
    private String firstName;
    private String lastName;
    private String yearOfBirth;
    private Gender gender;
    private String note;
}
