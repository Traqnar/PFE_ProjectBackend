package com.example.kickerdavinci.Repository;

import com.example.kickerdavinci.Models.Competition;
import com.example.kickerdavinci.Models.Cup;
import java.time.LocalDate;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

public interface CupsRepository extends CrudRepository<Cup, Long> {

  boolean existsByName(String name);

  Cup findByName(String name);

  Iterable<Cup> findAllByStartDateAndEndDate(LocalDate start, LocalDate end);

  @Transactional
  void deleteByName(String name);

}