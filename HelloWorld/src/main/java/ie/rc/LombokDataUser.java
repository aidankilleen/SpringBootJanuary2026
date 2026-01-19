package ie.rc;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LombokDataUser {
    private int id;
    private String name;
    private String email;
    private boolean active;
}
