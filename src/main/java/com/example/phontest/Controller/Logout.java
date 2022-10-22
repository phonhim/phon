package com.example.phontest.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Logout {
    @GetMapping("/logout")
    public String Logout() {

        return "redirect:/login";
    }
}
