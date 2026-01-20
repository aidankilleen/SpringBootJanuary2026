package ie.rc.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GeneralService {

    String notification;

    // you can use @Value in the parameters of
    // a constructor
    public GeneralService(@Value("${app.notification}")String msg) {
        this.notification = msg;
    }

    public void displayMessage() {
        System.out.println("XXXXXGeneralService.displayMessage()");
        System.out.println(notification);
        System.out.println("=====");
    }


}
