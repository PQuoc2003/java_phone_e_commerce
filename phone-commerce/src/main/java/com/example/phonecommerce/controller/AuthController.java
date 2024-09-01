package com.example.phonecommerce.controller;

import com.example.phonecommerce.models.Roles;
import com.example.phonecommerce.models.User;
import com.example.phonecommerce.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Slf4j
@Controller
public class AuthController {


    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = {"/", "/login"})
    public String loginForm(Model model, User user){
        model.addAttribute("user", user);
        return "Login";
    }

    @GetMapping(value = {"/register"})
    public String registerForm(Model model){
        model.addAttribute("newUser", new User());
        return "Register";
    }


    @PostMapping("/register")
    public String registerForm(@ModelAttribute("newUser") User newUser, Model model) {
        String password = newUser.getPassword();

//        Skip step encode password, will add later
//        newUser.setPassword(passwordEncoder.encode(password));

        newUser.setRoles(Roles.ROLES_USER);

        try {
            userService.saveUser(newUser);
            return "redirect:/login";
        }catch(Exception e){
            model.addAttribute("errorRegister", "Đăng ký không thành công, email đã tồn tại");
            return "redirect:/register";
        }
    }






}
