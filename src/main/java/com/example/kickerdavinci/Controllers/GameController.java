package com.example.kickerdavinci.Controllers;


import com.example.kickerdavinci.Models.Division;
import com.example.kickerdavinci.Services.ClubService;
import com.example.kickerdavinci.Services.CompetitionService;
import com.example.kickerdavinci.Services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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


}
