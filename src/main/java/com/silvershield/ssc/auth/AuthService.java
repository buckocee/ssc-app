package com.silvershield.ssc.auth;

import com.silvershield.ssc.repos.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.UUID;

@Service
public class AuthService {

    private final Logger _logger = LoggerFactory.getLogger(getClass());

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private JavaMailSender emailSender;

    @Autowired
    public AuthService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder,
                       JavaMailSender emailSender){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailSender = emailSender;
    }


    public User saveUser(User user){
        return userRepository.save(user);
    }


    User registerUser(UserDto userDto) throws Exception {

        if(userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            _logger.debug("User " + userDto.getEmail() + " already exists");
            throw new Exception("User " + userDto.getEmail() + " already exists");
        }
        final User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        user.setStatus(User.Status.REGISTERED);
        user.setRegistrationToken(UUID.randomUUID().toString());
        user.setRoles(Collections.singleton(roleRepository.findByName("ROLE_USER")
                .orElse(new Role("ROLE_USER"))));

        User savedUser = userRepository.save(user);
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
        _logger.info("User [{}] registration confirmed", user.getId());
        return user;
    }

    public void sendSimpleMessage(
            String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

}
