package com.silvershield.ssc.auth;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

    UserRepository userRepository;

    public AuthService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User saveUser(User user){
        User savedUser = userRepository.save(user);
        return savedUser;
    }
}
