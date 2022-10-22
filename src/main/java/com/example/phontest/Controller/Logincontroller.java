package com.example.phontest.Controller;

import com.example.phontest.Service.Logiservice;
import com.example.phontest.Entity.Login;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Controller
public class Logincontroller {
    @Autowired
    private Logiservice logiservice;
    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login_form/Login");
        mav.addObject("user", new Login());
        return mav;
    }


        @PostMapping("/login")
    public String login(@ModelAttribute("user") Login user ) {

        Login oauthUser = logiservice.login(user.getUsername(), user.getPassword());


        System.out.print(oauthUser);
        if(Objects.nonNull(oauthUser))
        {

            return "redirect:/list";


        } else {
            return "error/404";


        }

    }




}
