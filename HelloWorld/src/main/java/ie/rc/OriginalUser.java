package ie.rc;


// class is used for reading and writing to a table in a database
// POJO - Plain Old Java Object
public class OriginalUser {

    private int id;
    private String name;
    private String email;
    private boolean active;

    // default constructor
    public OriginalUser() {}

    public OriginalUser(int id, String name, String email, boolean active) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.active = active;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public String toString() {
        return "" + id + " " + name + " " + email + " " + (active ? "Active" : "Inactive");
    }
}
