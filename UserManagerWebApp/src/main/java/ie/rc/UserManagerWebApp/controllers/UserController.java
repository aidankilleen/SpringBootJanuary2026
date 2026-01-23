package ie.rc.UserManagerWebApp.controllers;

import ie.rc.daos.UserDao;
import ie.rc.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    UserDao dao;

    @GetMapping("/users")
    String getPage(Model model) {

        model.addAttribute("title", "User Manager");
        var users = dao.getAll();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/users/{id}")
    String getUserDetail(@PathVariable("id") int id, Model model) {

        var user = dao.getById(id);

        model.addAttribute("title", "User Detail - " + id);
        model.addAttribute("user", user);
        return "userdetail";
    }
    @GetMapping("/useradd")
    String showUserForm(Model model) {

        model.addAttribute("title", "Add User");
        return "userform";
    }

    @PostMapping("/useradd")
    String processUserForm() {

        System.out.println("Form submitted");
        return "useradded";
    }

}
