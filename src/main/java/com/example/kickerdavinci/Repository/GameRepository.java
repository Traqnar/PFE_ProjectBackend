package com.example.kickerdavinci.Repository;
import com.example.kickerdavinci.Models.Club;
import com.example.kickerdavinci.Models.Competition;
import com.example.kickerdavinci.Models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface GameRepository extends JpaRepository<Game, Long> {

    List<Game> findByHostClub(Club club);
    List<Game> findByGuestClub(Club club);
    boolean deleteById(long id);
    Game findById (long id);
    List<Game> findByCompetition(Competition competetion);
}


