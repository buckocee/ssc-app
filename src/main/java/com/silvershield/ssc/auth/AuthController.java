package com.silvershield.ssc.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/users")
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @GetMapping
    public UserDto index(){
        UserDto user = new UserDto();
        user.setEmail("john.doe@email.com");
        user.setFirstName("John");
        user.setLastName("Doe");

        return user;
    }

    @PostMapping(value = "/register")
    public User registerUser(@RequestBody UserDto userDto) throws Exception{
        return authService.registerUser(userDto);
    }
}
