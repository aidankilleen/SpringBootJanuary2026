package ie.rc;

public class ShowUser {

    private User user;

    public ShowUser(User user) {
        this.user = user;
    }
    public void display() {
        System.out.println("ShowUser.display() called");
        System.out.println(user);
    }
}
