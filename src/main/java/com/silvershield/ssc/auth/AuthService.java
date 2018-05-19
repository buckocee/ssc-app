package com.silvershield.ssc.auth;

import com.silvershield.ssc.repos.RoleRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AuthService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public User saveUser(User user){
        return userRepository.save(user);
    }


    public User registerUser(UserDto userDto) throws Exception {

        if(userRepository.findByEmail(userDto.getEmail()).isPresent())
            throw new Exception("User "+ userDto.getEmail() + " already exists");

        final User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        user.setRoles(Collections.singleton(roleRepository.findByName("ROLE_USER")
                .orElse(new Role("ROLE_USER"))));

        return userRepository.save(user);
    }

}
