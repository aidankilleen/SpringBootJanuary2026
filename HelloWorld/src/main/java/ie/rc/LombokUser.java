package ie.rc;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class LombokUser {
    private int id;
    @NonNull
    private String name;
    private String email;
    private boolean active;

}
