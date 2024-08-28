package com.example.phonecommerce.controller;

import com.example.phonecommerce.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class AuthController {

    @GetMapping(value = {"/", "/Login"})
    public String loginForm(Model model, User user){
        model.addAttribute("user", user);
        return "Login";
    }

}
