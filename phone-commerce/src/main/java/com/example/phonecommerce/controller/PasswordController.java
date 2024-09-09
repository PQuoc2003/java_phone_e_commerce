package com.example.phonecommerce.controller;

import com.example.phonecommerce.dto.EmailRequest;
import com.example.phonecommerce.models.User;
import com.example.phonecommerce.service.EmailService;
import com.example.phonecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class PasswordController {

    private final UserService userService;

    private EmailService emailService;

    private BCryptPasswordEncoder passwordEncoder;


    @Autowired
    public PasswordController(UserService userService, EmailService emailService, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.emailService = emailService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping(value = "/forgot-password")
    public String forgotPasswordForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "ForgetPassword";
    }


//    Mechanic is : generate new password and send to email of user.
//    User can change their password after receive new password.
    @PostMapping(value = "forgot-password")
    public String validatedPassword(@ModelAttribute("user") User currUser, Model model) {
        List<User> users = userService.findByEmail(currUser.getEmail());

        if (users.isEmpty()) {
            model.addAttribute("error", "Can't find your email");
            return "ForgetPassword";
        }


        EmailRequest emailRequest = new EmailRequest();

        emailRequest.setTo(currUser.getEmail());





        return "redirect:/Login";
    }


}