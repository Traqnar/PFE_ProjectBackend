package com.example.kickerdavinci.Services;

import com.example.kickerdavinci.Models.Cup;
import com.example.kickerdavinci.Models.model.NoIdCup;
import com.example.kickerdavinci.Repository.CupsRepository;
import java.time.LocalDate;
import org.springframework.stereotype.Service;

@Service
public class CupService {

  private final CupsRepository cupsRepository;

  public CupService(CupsRepository cupsRepository) {
    this.cupsRepository = cupsRepository;
  }

  public boolean createOne(NoIdCup cup) {
    if (cupsRepository.existsByName(cup.getName())) {
      return false;
    }
    cupsRepository.save(cup.toCup());
    return true;
  }

  public Cup getOne(String name) {
    if (!cupsRepository.existsByName(name)) {
      return null;
    }
    return cupsRepository.findByName(name);
  }

  public Iterable<Cup> getByStartAndEndDate(LocalDate start, LocalDate end) {
    Iterable<Cup> cups = cupsRepository.findAllByStartDateAndEndDate(start, end);
    return cups;
  }

  public Iterable<Cup> getAll() {
    return cupsRepository.findAll();
  }

  public boolean deleteByName(String name) {
    if (!cupsRepository.existsByName(name)) {
      return false;
    }
    cupsRepository.deleteByName(name);
    return true;
  }

  public boolean existsName(String name) {
    return cupsRepository.existsByName(name);
  }

  public boolean update(Cup cup, String name) {
    if (cupsRepository.existsByName(cup.getName())) {
      return false;
    }
    Cup cupDb = cupsRepository.findByName(name);
    cup.setId(cupDb.getId());
    cupsRepository.save(cup);
    System.out.println(cupsRepository.findAll());
    return true;
  }
}
