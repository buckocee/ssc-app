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
}
