package com.example.phonecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/home", "/homepage"})
    public String homePage() {
        return "homepage";
    }

    @GetMapping(value = "/403")
    public String forbidPage() {
        return "403";
    }


    @GetMapping(value =  "/error")
    public String errorPage() {return "redirect:/home";}


    @GetMapping(value = "/admin")
    public String adminHome() {
        return "admin_template/admin_home";
    }

}
