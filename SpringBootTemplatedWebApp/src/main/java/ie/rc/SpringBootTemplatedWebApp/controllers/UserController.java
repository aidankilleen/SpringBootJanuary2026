package ie.rc.SpringBootTemplatedWebApp.controllers;

import ie.rc.SpringBootTemplatedWebApp.daos.UserDao;
import ie.rc.SpringBootTemplatedWebApp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {

    @Autowired
    UserDao dao;

    @GetMapping("/users")
    String getUserPage(Model model) {

        var users = dao.getAll();
        System.out.println(users);

        model.addAttribute("title",
                "User List Page");

        var user = new User(1, "Alice", "alice@gmail.com", true);
        model.addAttribute("user", user);


        model.addAttribute("users",users
        );

        return "users";
    }
    @GetMapping("/users/{id}")
    String getUser(Model model, @PathVariable int id) {
        model.addAttribute("title", "User Details - %d".formatted(id));
        var user = dao.getById(id);
        model.addAttribute("user", user);
        return "user";
    }



}
