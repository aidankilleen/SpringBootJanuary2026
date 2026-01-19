package ie.rc.models;

public record User(int id,
                   String name,
                   String email,
                   boolean active) {
}
