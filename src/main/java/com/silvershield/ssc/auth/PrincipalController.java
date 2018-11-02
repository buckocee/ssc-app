package com.silvershield.ssc.auth;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrincipalController {

  private final UserRepository userRepository;

  @Autowired
  public PrincipalController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @RequestMapping("/user")
  public User user(Principal principal) {
    User user = userRepository.findByEmail(principal.getName()).orElse(null);
    return user;
  }
}
