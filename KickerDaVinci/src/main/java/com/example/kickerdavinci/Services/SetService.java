package com.example.kickerdavinci.Services;

import com.example.kickerdavinci.Repository.SetRepository;
import com.example.kickerdavinci.Repository.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class SetService {

  private final SetRepository setRepository;

  public SetService(SetRepository setRepository) {
    this.setRepository = setRepository;
  }

  public boolean createOne() {
    return true;
  }
}
