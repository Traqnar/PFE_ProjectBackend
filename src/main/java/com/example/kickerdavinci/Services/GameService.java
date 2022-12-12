package com.example.kickerdavinci.Services;

import com.example.kickerdavinci.Repository.GameRepository;
import org.springframework.stereotype.Service;

@Service
public class GameService {

  private final GameRepository gameRepository;

  public GameService(GameRepository gameRepository) {
    this.gameRepository = gameRepository;
  }

  public boolean createOne() {
    return true;
  }
}
