package com.example.kickerdavinci.Controllers;

import com.example.kickerdavinci.Models.User;
import com.example.kickerdavinci.Models.model.Credentials;
import com.example.kickerdavinci.Models.model.NoIdUser;
import com.example.kickerdavinci.Services.UserService;
import java.time.LocalDate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/user")
  public ResponseEntity<Void> createUser(@RequestBody NoIdUser user) {
    if (user.getLastname() == null || user.getLastname().equals("") || user.getFirstname() == null
        || user.getFirstname().equals("") || user.getEmail() == null || user.getEmail()
        .equals("")
        || user.getPassword() == null || user.getPassword().equals("") || user.getBirthDate()
        .isAfter(
            LocalDate.now())) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
    if (!userService.createOne(user)) {
      throw new ResponseStatusException(HttpStatus.CONFLICT);
    }
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PutMapping("/user/{email}")
  public ResponseEntity<Void> updateUser(@RequestBody NoIdUser user, @PathVariable String email,
      @RequestHeader("Authorization") String token) {
    String userVerified = userService.verify(token);
    if (!userVerified.equals(email)) {
      throw new ResponseStatusException(HttpStatus.FORBIDDEN);
    }

    if (user.getLastname() == null || user.getLastname().equals("") || user.getFirstname() == null
        || user.getFirstname().equals("") || user.getEmail() == null || user.getEmail()
        .equals("")
        || user.getPassword() == null || user.getPassword().equals("") || user.getBirthDate()
        .isAfter(
            LocalDate.now()) /*|| user.getClub() == null*/ || email.equals(user.getEmail())) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
    if (!userService.existsEmail(email)) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    if (!userService.update(user.toUser(), email)) {
      throw new ResponseStatusException(HttpStatus.CONFLICT);
    }
    return new ResponseEntity<>(HttpStatus.OK);

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

  @GetMapping("/users")
  public ResponseEntity<Iterable<User>> getAll() {
    return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
  }

  @GetMapping("/users/admin")
  public ResponseEntity<Iterable<User>> findAllByFlag(){return new ResponseEntity<>(userService.findAllByFlag(), HttpStatus.OK);}

}
