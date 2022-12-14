package com.example.kickerdavinci.Repository;
import com.example.kickerdavinci.Models.Game;
import com.example.kickerdavinci.Models.GameRecap;
import com.example.kickerdavinci.Models.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface SetRepository extends JpaRepository<Set, Long> {

    boolean existsByGameRecap(GameRecap gameRecap);
    Set findByGameRecap(GameRecap gameRecap);

    }


