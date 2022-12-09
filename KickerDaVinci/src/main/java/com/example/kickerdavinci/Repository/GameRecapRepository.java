package com.example.kickerdavinci.Repository;
import com.example.kickerdavinci.Models.Game;
import com.example.kickerdavinci.Models.GameRecap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface GameRecapRepository extends JpaRepository<GameRecap, Long> {

    boolean existsByGame(Game game);
}


