package lisakom.com.entities;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class EmailNotification {
    private String to;
    private String theme;
    private String template;
    private String text;
}
