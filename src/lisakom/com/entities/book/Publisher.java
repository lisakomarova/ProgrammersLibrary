package lisakom.com.entities.book;

import lisakom.com.enumerations.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
@AllArgsConstructor
public class Publisher implements Serializable {
    private Country country;
    private String address;
    private String zipcode;
    private String email;

}
