package com.example.kickerdavinci.Repository;

import com.example.kickerdavinci.Models.Club;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubsRepository extends CrudRepository<Club, Long> {

}
