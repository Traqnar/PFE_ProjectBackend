package com.example.kickerdavinci.Controllers;


import com.example.kickerdavinci.Services.GameService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

  private final GameService gameService;

  public GameController(GameService gameService) {
    this.gameService = gameService;
  }
}
