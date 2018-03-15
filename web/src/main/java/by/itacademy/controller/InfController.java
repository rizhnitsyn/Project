package by.itacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InfController {

    @GetMapping("/information")
    public String showAdminPage() {
        return "information";
    }
}
