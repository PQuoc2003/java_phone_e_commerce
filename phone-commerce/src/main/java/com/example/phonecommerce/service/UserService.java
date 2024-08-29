package com.example.phonecommerce.service;

import com.example.phonecommerce.models.User;

import java.util.List;

public interface UserService{

    List<User> findByUsername(String username);


}
