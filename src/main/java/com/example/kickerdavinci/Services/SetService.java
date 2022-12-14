package com.example.kickerdavinci.Services;

import com.example.kickerdavinci.Models.GameRecap;
import com.example.kickerdavinci.Models.Set;
import com.example.kickerdavinci.Models.model.NoIdGameRecap;
import com.example.kickerdavinci.Models.model.NoIdSet;
import com.example.kickerdavinci.Repository.SetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetService {

  private final SetRepository setRepository;

  public SetService(SetRepository setRepository) {
    this.setRepository = setRepository;
  }

  public boolean createOne(NoIdSet set) {
    setRepository.save(set.toSet());
    return true;
  }

  public List<Set> getAll(){
    return setRepository.findAll();
  }

  public boolean deleteById(long id) {
    if (!setRepository.existsById(id)) {
      return false;
    }
    setRepository.deleteById(id);
    return true;
  }
}
