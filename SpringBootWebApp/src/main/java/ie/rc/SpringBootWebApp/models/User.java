package ie.rc.SpringBootWebApp.models;

public record User(
        int id,
        String name,
        String email,
        boolean active) {
}
