package com.example.kickerdavinci.Controllers;

import com.example.kickerdavinci.Models.Club;
import com.example.kickerdavinci.Models.model.NoIdClub;
import com.example.kickerdavinci.Services.ClubService;
import com.example.kickerdavinci.Services.DivisionService;
import com.example.kickerdavinci.Services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ClubController {

  private final ClubService clubService;

  private final UserService userService;
  private final DivisionService divisionService;

  public ClubController(ClubService clubService, UserService userService,
      DivisionService divisionService) {
    this.clubService = clubService;
    this.userService = userService;
    this.divisionService = divisionService;
  }


  @PostMapping("/club")
  public ResponseEntity<Void> createOne(@RequestBody NoIdClub club) {
    if (club.getName() == null || club.getName().equals("") || club.getAdresse() == null
        || club.getAdresse().equals("")
        || club.getLocal() == null || club.getLocal().equals("") || club.getPhone() == null
        || club.getPhone().equals("")
        || club.getCaptainPhone() == null || club.getCaptainPhone().equals("")) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
    if (!userService.existsEmail(club.getCaptain().getEmail())) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This user doesn't exist");
    } /*else {
      if (!club.getName().equals(club.getCaptain().getClub().getName())) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This user is not in this club");
      }
    }
    */
    if (!divisionService.existsName(club.getDivision().getName())) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This division doesn't exist");
    }
    if (!clubService.createOne(club)) {
      throw new ResponseStatusException(HttpStatus.CONFLICT);
    }
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping("/clubs")
  public ResponseEntity<Iterable<Club>> getAll() {
    return new ResponseEntity<>(clubService.getAll(), HttpStatus.OK);
  }

  @GetMapping("/club/{name}")
  public ResponseEntity<Club> getClubByName(@PathVariable String name) {
    if (name.equals("") || name == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
    Club club = clubService.getClubByName(name);
    if (club == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(club, HttpStatus.OK);
  }


  @DeleteMapping("/club/{name}")
  public ResponseEntity<Void> deleteByName(@PathVariable String name) {
    if (name.equals("") || name == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
    if (!clubService.deleteByName(name)) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PutMapping("/club/{name}")
  public ResponseEntity<Void> updateDivision(@RequestBody NoIdClub club,
      @PathVariable String name) {
    if (club.getName() == null || club.getName().equals("") || club.getAdresse() == null
        || club.getAdresse().equals("")
        || club.getLocal() == null || club.getLocal().equals("") || club.getPhone() == null
        || club.getPhone().equals("")
        || club.getCaptainPhone() == null || club.getCaptainPhone().equals("")) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
    if (!userService.existsEmail(club.getCaptain().getEmail())) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This user doesn't exist");
    } /*else {
      if (!club.getName().equals(club.getCaptain().getClub().getName())) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This user is not in this club");
      }
    }
    */
    if (!divisionService.existsName(club.getDivision().getName())) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This division doesn't exist");
    }
    if (!clubService.existsName(name)) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    if (!clubService.update(club.toClub(), name)) {
      throw new ResponseStatusException(HttpStatus.CONFLICT);
    }
    return new ResponseEntity<>(HttpStatus.OK);

  }
}
