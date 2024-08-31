package com.example.phonecommerce.controller;

import com.example.phonecommerce.models.Role;
import com.example.phonecommerce.models.User;
import com.example.phonecommerce.service.RoleService;
import com.example.phonecommerce.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class AuthController {

    private final RoleService roleService;

    private final UserService userService;

    @Autowired
    public AuthController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping(value = {"/", "/Login"})
    public String loginForm(Model model, User user){
        model.addAttribute("user", user);
        return "Login";
    }

    @GetMapping(value = {"/register"})
    public String registerForm(Model model){
        model.addAttribute("newUser", new User());
        return "Register";
    }


    @PostMapping("/Register")
    public String registerForm(@ModelAttribute("newUser") User newUser, Model model) {
        String password = newUser.getPassword();

//        Skip step encode password, will add later
//        newUser.setPassword(passwordEncoder.encode(password));

        //set mac dinh role user
        List<Role> roles = new ArrayList<>();
        roles.add(roleService.findById(2));
        newUser.setRoles(roles);
        try {
            userService.saveUser(newUser);
            return "redirect:/Login";
        }catch(Exception e){
            model.addAttribute("errorRegister", "Đăng ký không thành công, email đã tồn tại");
            return "redirect:/Register";
        }
    }






}
