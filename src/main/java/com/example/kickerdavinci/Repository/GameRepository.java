package com.example.kickerdavinci.Repository;
import com.example.kickerdavinci.Models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface GameRepository extends JpaRepository<Game, Long> {

    }


