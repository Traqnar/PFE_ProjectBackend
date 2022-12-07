package com.example.kickerdavinci.Controllers;

import com.example.kickerdavinci.Models.Credentials;
import com.example.kickerdavinci.Models.NoIdUser;
import com.example.kickerdavinci.Services.UserService;
import java.time.LocalDate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/user")
  ResponseEntity<Void> createUser(@RequestBody NoIdUser user) {
    if (user.getLastname() == null || user.getLastname().equals("") || user.getFirstname() == null
        || user.getFirstname().equals("") || user.getEmail() == null || user.getEmail()
        .equals("")
        || user.getPassword() == null || user.getPassword().equals("") || user.getBirthDate()
        .isAfter(
            LocalDate.now()) || user.getIdClub() <= 0) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
    if (!userService.createOne(user)) {
      throw new ResponseStatusException(HttpStatus.CONFLICT);
    }
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PostMapping("/authentication/connect")
  public String connect(@RequestBody Credentials credentials) {
    if (credentials.getEmail() == null || credentials.getPassword() == null
        || credentials.getPassword()
        .equals("") || credentials.getEmail()
        .equals("")) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
    String token = userService.connect(credentials);
    if (token == null) {
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
    }
    return token;
  }

}
