package ie.rc.SpringBootTemplatedWebApp.controllers;

import ie.rc.SpringBootTemplatedWebApp.daos.UserDao;
import ie.rc.SpringBootTemplatedWebApp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PageController {

    @Autowired
    UserDao dao;

    @GetMapping("/page")
    public String getPage() {
        return "<h1>Page</h1>";
    }

    @GetMapping("/userlist")
    public List<User> getUsers() {

        return dao.getAll();
    }
}
