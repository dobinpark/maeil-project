package maeil.maeilproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class MainController {

    @GetMapping("main")
    public String hello() {

        return "main";
    }
}
