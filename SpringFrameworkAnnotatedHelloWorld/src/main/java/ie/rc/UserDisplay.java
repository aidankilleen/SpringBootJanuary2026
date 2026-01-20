package ie.rc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDisplay {

    @Autowired
    private User user;

    public void display() {
        System.out.println("UserDisplay.display()");

        System.out.println(user);
    }
}
