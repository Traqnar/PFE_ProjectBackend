package com.example.kickerdavinci.Repository;

import com.example.kickerdavinci.Models.Division;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DivisionsRepository extends JpaRepository<Division, Long> {

  boolean existsByName(String name);

  Division findByName(String name);

  @Transactional
  void deleteByName(String name);

    Division getByName(String divisionName);
}
