package com.example.kickerdavinci.Controllers;

import com.example.kickerdavinci.Models.Club;
import com.example.kickerdavinci.Models.Game;
import com.example.kickerdavinci.Models.GameRecap;
import com.example.kickerdavinci.Models.model.NoIdGame;
import com.example.kickerdavinci.Models.model.NoIdGameRecap;
import com.example.kickerdavinci.Services.GameRecapService;
import com.example.kickerdavinci.Services.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;

@RestController
public class GameRecapController {

  private final GameRecapService gameRecapService;
  private final GameService gameService;

  public GameRecapController(GameRecapService gameRecapService, GameService gameService) {
    this.gameRecapService = gameRecapService;
    this.gameService = gameService;
  }


  @PostMapping("/gameRecap")
  public ResponseEntity<Void> createOne(@RequestBody NoIdGameRecap gameRecap) {
    if (!gameRecapService.createOne(gameRecap)) {
      throw new ResponseStatusException(HttpStatus.CONFLICT);
    }
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping("/gameRecaps")
  public ResponseEntity<List<GameRecap>> getAll() {
    return new ResponseEntity<>(gameRecapService.getAll(), HttpStatus.OK);
  }

  @DeleteMapping("/gameRecap/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable long id) {
    if (!gameRecapService.deleteById(id)) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping("/gameRecap/{id}")
    public ResponseEntity<GameRecap>getByGame(@PathVariable long id){
    return new ResponseEntity<>(gameRecapService.getByGame(gameService.findGamebyId(id)),HttpStatus.OK);
    }

}
