package ie.rc.SpringBootTemplatedWebApp.controllers;

import ie.rc.SpringBootTemplatedWebApp.daos.UserDao;
import ie.rc.SpringBootTemplatedWebApp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplatedController {



    @GetMapping("/templatedindex")
    String getTemplatedPage(Model model) {

        model.addAttribute("title",
                "This is the Title");
        return "templatedindex";
    }


}
