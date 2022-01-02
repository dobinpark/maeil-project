package maeil.maeilproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("Home")
    public String hello() {

        return "Home";
    }
}
