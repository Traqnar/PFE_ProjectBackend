package com.example.kickerdavinci.Services;

import com.example.kickerdavinci.Models.GameRecap;
import com.example.kickerdavinci.Models.model.NoIdClub;
import com.example.kickerdavinci.Models.model.NoIdGameRecap;
import com.example.kickerdavinci.Repository.GameRecapRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameRecapService {

  private final GameRecapRepository gameRecapRepository;

  public GameRecapService(GameRecapRepository gameRecapRepository) {
    this.gameRecapRepository = gameRecapRepository;
  }

    public boolean createOne(NoIdGameRecap gameRecap) {
      gameRecapRepository.save(gameRecap.toGameRecap());
      return true;
    }

    public List<GameRecap> getAll(){
     return gameRecapRepository.findAll();
    }

  public boolean deleteById(long id) {
    if (!gameRecapRepository.existsById(id)) {
      return false;
    }
    gameRecapRepository.deleteById(id);
    return true;
  }
  }

