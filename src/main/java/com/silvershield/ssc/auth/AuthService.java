package com.silvershield.ssc.auth;

import com.silvershield.ssc.repos.RoleRepository;
import com.silvershield.ssc.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class AuthService {

    private final Logger _logger = LoggerFactory.getLogger(getClass());

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
//    private final PasswordEncoder passwordEncoder;
    private final MailService emailSender;

    @Autowired
    public AuthService(UserRepository userRepository, RoleRepository roleRepository,
                       MailService emailSender) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
//        this.passwordEncoder = passwordEncoder;
        this.emailSender = emailSender;
    }


    public User saveUser(User user){
        return userRepository.save(user);
    }


    List<User> getUsers(){
        return userRepository.findAll();
    }

    User registerUser(UserDto userDto) throws Exception {

        if(userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            _logger.debug("User " + userDto.getEmail() + " already exists");
            throw new Exception("User " + userDto.getEmail() + " already exists");
        }
        final User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
//        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        user.setStatus(User.Status.REGISTERED);
        user.setRegistrationToken(UUID.randomUUID().toString());
        user.setRoles(Collections.singleton(roleRepository.findByName("ROLE_USER")
                .orElse(new Role("ROLE_USER"))));
        User savedUser = userRepository.save(user);
        emailSender.sendNewActivationRequest(savedUser.getEmail(), user.getRegistrationToken());
        _logger.info("Created user [{}]", savedUser.getId());

        return savedUser;
    }

    User confirmRegistration(String token) throws Exception {
        User user = userRepository.findByRegistrationToken(token).orElseThrow(() -> new Exception("Invalid confirmation token"));
        if(user.getStatus() != User.Status.REGISTERED) {
            _logger.debug("User [{}] already confirmed", user.getId());
            throw new Exception("User already confirmed");
        }
        user.setStatus(User.Status.ACTIVE);
        user.setActive(true);
        _logger.info("User [{}] registration confirmed", user.getId());
        return user;
    }

    void resetPassword(String token){

    }

    public User findUserByEmail(String email) throws Exception {
        return userRepository.findByEmail(email).orElseThrow(() -> new Exception(String.format("Username %s not found!", email)));
    }

    public User getAuthenticatedUser() throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return findUserByEmail(auth.getName());
    }

    public boolean isAdmin(User user) {
        return user.getRoles().stream().anyMatch(role -> role.getName().equalsIgnoreCase("ROLE_ADMIN"));
    }
}
