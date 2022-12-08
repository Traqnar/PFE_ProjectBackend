package com.example.kickerdavinci.Repository;

import com.example.kickerdavinci.Models.Division;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

public interface DivisionsRepository extends CrudRepository<Division, Long> {

  boolean existsByName(String name);

  Division findByName(String name);

  @Transactional
  void deleteByName(String name);

}
