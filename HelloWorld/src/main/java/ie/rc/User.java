package ie.rc;

// records were added to Java in v 16 (2021)
public record User(int id,
                   String name,
                   String email,
                   boolean active) {
}
