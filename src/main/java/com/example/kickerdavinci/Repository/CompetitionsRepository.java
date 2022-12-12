package com.example.kickerdavinci.Repository;

import com.example.kickerdavinci.Models.Competition;
import java.time.LocalDate;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

public interface CompetitionsRepository extends CrudRepository<Competition, Long> {

  boolean existsByDate(LocalDate date);

  Competition findByDate(LocalDate date);

  @Transactional
  void deleteByDate(LocalDate date);
}
