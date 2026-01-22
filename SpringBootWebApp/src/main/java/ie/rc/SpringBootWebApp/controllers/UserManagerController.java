package ie.rc.SpringBootWebApp.controllers;

import ie.rc.SpringBootWebApp.models.User;
import ie.rc.SpringBootWebApp.services.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserManagerController {

    @Autowired
    UserManagerService userManagerService;

    @GetMapping("/usermanager")
    List<User> getActiveUsers() {
        return userManagerService.getActiveUsers();
    }
}
