package com.example.kickerdavinci.Repository;

import com.example.kickerdavinci.Models.Cup;
import java.time.LocalDate;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CupsRepository extends JpaRepository<Cup, Long> {

  boolean existsByName(String name);

  Cup findByName(String name);

  Iterable<Cup> findAllByStartDateAndEndDate(LocalDate start, LocalDate end);

  @Transactional
  void deleteByName(String name);

}