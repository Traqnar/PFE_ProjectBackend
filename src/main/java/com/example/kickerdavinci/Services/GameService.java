package com.example.kickerdavinci.Services;

import com.example.kickerdavinci.Models.Club;
import com.example.kickerdavinci.Models.Competition;
import com.example.kickerdavinci.Models.Game;
import com.example.kickerdavinci.Models.model.NoIdGame;
import com.example.kickerdavinci.Repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

  private final GameRepository gameRepository;

  public GameService(GameRepository gameRepository) {
    this.gameRepository = gameRepository;
  }

  public boolean createOne(NoIdGame game) {
    return true;
  }

  public Iterable<Game> findByCompetitionId(Competition competition) {
    return gameRepository.findByCompetition(competition);
  }
    public Iterable<Game> getAll(){
    return gameRepository.findAll();
    }
    public Iterable<Game> getAllHostClub(Club club){
    return gameRepository.findByHostClub(club);
    }
  public Iterable<Game> getAllGuestClub(Club club){
    return gameRepository.findByGuestClub(club);
  }
  public boolean deleteById(long id) {
    if (!gameRepository.existsById(id)) {
    return false;
  }
    gameRepository.deleteById(id);
    return true;
  }
}
