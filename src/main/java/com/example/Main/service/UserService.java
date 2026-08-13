package com.example.Main.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.example.Main.entity.User;
import com.example.Main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User saveUser(User user){

        if(userRepository.existsByUsername(user.getUsername())
                || userRepository.existsByEmail(user.getEmail())){

            return null;
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if(user.getRole() == null || user.getRole().isEmpty()){
            user.setRole("USER");
        }

        return userRepository.save(user);
    }

    public User getUserByUsername(String username){

        return userRepository.findByUsername(username);

    }

}