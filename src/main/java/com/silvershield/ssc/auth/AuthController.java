package com.silvershield.ssc.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/users")
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @GetMapping
    public List<User> index(){
        return authService.getUsers();
    }

    @PostMapping(value = "/register")
    public User registerUser(@RequestBody UserDto userDto) throws Exception{
        return authService.registerUser(userDto);
    }

    @GetMapping(value = "/confirm-registration/{token}")
    public User confirmRegistration(@PathVariable String token) throws Exception{
        return authService.confirmRegistration(token);  // TODO handle different exception types (invalid, already exists)
    }

    @PostMapping(value = "/reset-password")
    public String resetPassword(){
        // TODO send email with password reset token
        return null;
    }

    @PostMapping(value = "/update-password")
    public String changePassword(PasswordResetDTO passwordResetDTO){

        // TODO validate reset token
        // TODO validate passwords match
        // TODO update password
        return null;
    }

    @GetMapping(value = "/reset-token/{id}")
    public String getPasswordResetToken(@PathVariable(value = "id") Integer userId){

        // TODO get password reset token from authservice
        return null;
    }
}

