package com.example.kickerdavinci.Controllers;

import com.example.kickerdavinci.Services.GameRecapService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameRecapController {

  private final GameRecapService gameRecapService;

  public GameRecapController(GameRecapService gameRecapService) {
    this.gameRecapService = gameRecapService;
  }
}
