package lisakom.com.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
@Data
@ToString
@AllArgsConstructor
public class Picture implements Serializable {
    private String fileName;
    private LocalDate downloadDate;
    private String comment;
}
