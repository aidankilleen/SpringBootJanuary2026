package ie.rc.SpringBootJdbc.models;

public record User(int id,
                   String name,
                   String email,
                   boolean active) {
}
