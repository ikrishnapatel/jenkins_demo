package com.springk.apidemos.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class LoginController {

    @GetMapping("/")
    public String getLoginPage()
    {
        return "Login";
    }
    
}
