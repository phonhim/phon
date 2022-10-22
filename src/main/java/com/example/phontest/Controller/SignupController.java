package com.example.phontest.Controller;

import com.example.phontest.Entity.Login;
import com.example.phontest.Service.Logiservice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {
    private final Logiservice logiservice;

    public SignupController(Logiservice logiservice) {
        this.logiservice = logiservice;
    }

    @GetMapping("/signup")
    public String signUp() {
        return "signup/create";
    }
    @PostMapping("/signup/create")
    public String signUpCreate(@ModelAttribute("Login") Login req) {
       // ModelAndView mav = new ModelAndView("signUp/create");
        if(saveSignUp(req)){
            return "redirect:/";
        }else {
            return "redirect:/signup";
        }
    }

    private boolean saveSignUp(Login req){
         boolean con = false;
        if(req.getPassword() != "" && req.getUsername() != ""){
            logiservice.saveRegisterLogin(req);
            return  true;
        }
        return  con;
    }
}
