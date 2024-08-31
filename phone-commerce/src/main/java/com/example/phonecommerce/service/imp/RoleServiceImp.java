package com.example.phonecommerce.service.imp;

import com.example.phonecommerce.models.Role;
import com.example.phonecommerce.repository.RoleRepository;
import com.example.phonecommerce.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleServiceImp implements RoleService {


    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImp(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findById(long id) {
        return roleRepository.findById(id);
    }
}
