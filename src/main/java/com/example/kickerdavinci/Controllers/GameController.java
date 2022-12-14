package com.example.kickerdavinci.Controllers;


import com.example.kickerdavinci.Models.Club;
import com.example.kickerdavinci.Models.Division;
import com.example.kickerdavinci.Models.Game;
import com.example.kickerdavinci.Models.model.NoIdGame;
import com.example.kickerdavinci.Services.ClubService;
import com.example.kickerdavinci.Services.CompetitionService;
import com.example.kickerdavinci.Services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@RestController
public class GameController {

  @Autowired
  private final GameService gameService;
  @Autowired
  private final CompetitionService competitionService;
  @Autowired
  private final ClubService clubService;

  public GameController(GameService gameService, CompetitionService competitionService, ClubService clubService) {
    this.gameService = gameService;
    this.competitionService = competitionService;
    this.clubService = clubService;
  }

  @PostMapping("/game")
  public ResponseEntity<Void> createOne(@RequestBody NoIdGame game) {
    if (!gameService.createOne(game)) {
      throw new ResponseStatusException(HttpStatus.CONFLICT);
    }
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping("/game/host/{hostClubName}")
  public ResponseEntity<List<Game>> findGamesByHostName(@PathVariable String hostClubName) {
    if (hostClubName == null || hostClubName.equals("")) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
    Club club = clubService.getClubByName(hostClubName);
    List<Game> games = gameService.getAllHostClub(club);
    return ResponseEntity.ok(games);
  }
  @GetMapping("/game/guest/{guestClubName}")
  public ResponseEntity<List<Game>> findGamesByGuestName(@PathVariable String guestClubName) {
    if (guestClubName == null || guestClubName.equals("")) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
    Club club = clubService.getClubByName(guestClubName);
    List<Game> games = gameService.getAllGuestClub(club);
    return ResponseEntity.ok(games);
  }

  @GetMapping("/games")
  public ResponseEntity<Iterable<Game>> getAllGames() {
    return new ResponseEntity<>(gameService.getAll(), HttpStatus.OK);
  }

  @DeleteMapping("/game/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable long id) {
    if (!gameService.deleteById(id)) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(HttpStatus.OK);
  }

}
