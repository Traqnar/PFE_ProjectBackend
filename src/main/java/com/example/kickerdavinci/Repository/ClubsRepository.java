package com.example.kickerdavinci.Repository;

import com.example.kickerdavinci.Models.Club;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubsRepository extends JpaRepository<Club, Long> {

  boolean existsByName(String name);

  Club findByName(String name);

  @Transactional
  void deleteByName(String name);
}
