package ie.rc.UserManagerWebApp.controllers;

import ie.rc.daos.UserDao;
import ie.rc.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

        User user = new User(-1,
                "",
                "",
                false);

        model.addAttribute("title", "Add User");
        model.addAttribute("user", user);
        return "userform";
    }

    @PostMapping("/useradd")
    String processUserForm(@ModelAttribute("user") User user,
                           BindingResult bindingResult,
                           Model model) {
        User addedUser = dao.add(user);

        model.addAttribute("title", "User Added Successfully");
        model.addAttribute("user", addedUser);
        return "useradded";
    }

    @GetMapping("/deleteuser/{id}")
    String showConfirmDelete(@PathVariable("id") int id, Model model) {
        var user = dao.getById(id);
        model.addAttribute("title", "Are you sure?");
        model.addAttribute("user", user);
        model.addAttribute("message", "Delete user %d".formatted(user.id()));
        return "confirmdelete";
    }

    @PostMapping("/deleteuser")
    String doDelete (@RequestParam int id,
                     @RequestParam String action) {
        if (action.equals("Delete")) {
            dao.delete(id);
        }
        return "redirect:/users";
    }

    @GetMapping("/edituser/{id}")
    String showEditDialog(@PathVariable int id, Model model) {

        User user = dao.getById(id);
        model.addAttribute("title", "Edit User");
        model.addAttribute("user", user);

        return "edituserform";
    }
    @PostMapping("/edituser")
    String doEdit(@ModelAttribute("user") User user,
                  BindingResult bindingResult) {

        dao.update(user);
        return "redirect:/users";
    }




}
