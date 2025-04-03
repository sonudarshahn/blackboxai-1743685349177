package com.example.reportsapp.config;

import com.example.reportsapp.entity.ERole;
import com.example.reportsapp.entity.Role;
import com.example.reportsapp.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.findByName(ERole.ROLE_USER).isEmpty()) {
            roleRepository.save(new Role(ERole.ROLE_USER));
        }
        if (roleRepository.findByName(ERole.ROLE_ADMIN).isEmpty()) {
            roleRepository.save(new Role(ERole.ROLE_ADMIN));
        }
    }
}