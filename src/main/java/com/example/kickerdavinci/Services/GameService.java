package com.example.kickerdavinci.Services;

import com.example.kickerdavinci.Models.Game;
import com.example.kickerdavinci.Repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

  private final GameRepository gameRepository;

  public GameService(GameRepository gameRepository) {
    this.gameRepository = gameRepository;
  }

  public boolean createOne() {
    return true;
  }

    public List<Game> findByCompetitionId(long id) {
    return gameRepository.findByCompetition(id);
    }
}
