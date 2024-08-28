package com.example.phonecommerce.service.imp;

import com.example.phonecommerce.models.User;
import com.example.phonecommerce.repository.UserRepository;
import com.example.phonecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {


    private final UserRepository userRepository;


    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }
}
