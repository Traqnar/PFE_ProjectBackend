package com.example.kickerdavinci.Services;

import com.example.kickerdavinci.Repository.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class ClubService {

  private final UsersRepository usersRepository;

  public ClubService(UsersRepository usersRepository) {
    this.usersRepository = usersRepository;
  }

  public boolean createOne() {
    return true;
  }
}
