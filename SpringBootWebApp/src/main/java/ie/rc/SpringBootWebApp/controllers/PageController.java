package ie.rc.SpringBootWebApp.controllers;

import ie.rc.SpringBootWebApp.daos.UserDao;
import ie.rc.SpringBootWebApp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PageController {

    @Value("${spring.application.title}")
    String title;

    @Autowired
    String message;

    @Autowired
    User user;

    @Autowired
    UserDao dao;

    @GetMapping("/page")
    public String getPage() {

        System.out.println("/page requested");
        return "<h1>%s</h1><p>%s</p>"
                .formatted(title, message);
    }

    @GetMapping("/user")
    public User getUser() {
        return user;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return dao.getAll();
    }

}
