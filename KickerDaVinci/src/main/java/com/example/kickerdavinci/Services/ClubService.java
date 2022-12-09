package com.example.kickerdavinci.Services;

import com.example.kickerdavinci.Repository.ClubsRepository;
import com.example.kickerdavinci.Repository.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class ClubService {

  private final ClubsRepository clubsRepository;

  public ClubService(ClubsRepository clubsRepository) {
    this.clubsRepository = clubsRepository;
  }

  public boolean createOne() {
    return true;
  }
}
