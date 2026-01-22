package ie.rc.SpringBootWebApp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrokenController {

    @RequestMapping("/broken")
    public String broken() {

        throw new UnsupportedOperationException("broken method");
    }
}
