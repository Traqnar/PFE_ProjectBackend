package com.example.kickerdavinci.Repository;

import com.example.kickerdavinci.Models.Ranking;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

public interface RankingsRepository extends CrudRepository<Ranking, Long> {

  boolean existsByName(String name);

  Ranking findByName(String name);

  @Transactional
  void deleteByName(String name);
}
