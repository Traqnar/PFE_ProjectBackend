package com.example.kickerdavinci.Repository;

import com.example.kickerdavinci.Models.Competition;
import java.time.LocalDate;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetitionsRepository extends JpaRepository<Competition, Long> {

  boolean existsByDate(LocalDate date);

  Competition findByDate(LocalDate date);

  Competition findById(long id);

  @Transactional
  void deleteByDate(LocalDate date);
}
