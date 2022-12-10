package com.example.kickerdavinci.Services;

import com.example.kickerdavinci.Repository.GameRecapRepository;
import org.springframework.stereotype.Service;

@Service
public class GameRecapService {

  private final GameRecapRepository gameRecapRepository;

  public GameRecapService(GameRecapRepository gameRecapRepository) {
    this.gameRecapRepository = gameRecapRepository;
  }

  public boolean createOne() {
    return true;
  }
}
