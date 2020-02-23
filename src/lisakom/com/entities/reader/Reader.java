package lisakom.com.entities.reader;

import lisakom.com.entities.reader.IdentificationCard;
import lombok.*;

import java.io.Serializable;

@ToString
@EqualsAndHashCode
@Data
@AllArgsConstructor
public class Reader implements Serializable {
    @NonNull
    private IdentificationCard identificationCard;
    private boolean hasBook;
}
