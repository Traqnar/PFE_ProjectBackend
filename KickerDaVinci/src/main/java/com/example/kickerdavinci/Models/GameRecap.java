package com.example.kickerdavinci.Models;

import javax.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "GameRecaps")
public class GameRecap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long Id;

    @OneToOne
    @JoinColumn(name="GAME_ID",unique = true, nullable = false)
    private Game game;

    @Column(name="host_score",nullable = false)
    private int hostScore;
    @Column(name = "guest-score",nullable = false)
    private int guestScore;

    @OneToMany(mappedBy = "recap")
    private List<Set> sets;

}
