package com.silvershield.ssc.auth;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> index(){
        return authService.getUsers();
    }

    @PostMapping(value = "/register")
    @ResponseStatus(HttpStatus.CREATED)
    public User registerUser(@RequestBody UserDto userDto) throws Exception{
        return authService.registerUser(userDto);
    }

    @GetMapping(value = "/confirm-registration/{token}")
    @ResponseStatus(HttpStatus.OK)
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

