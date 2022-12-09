package com.example.kickerdavinci.Models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Rankings")
public class Ranking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long Id;
    @Column(unique = true, name = "name", nullable = false)
    private String name;

    @Column(name="min_points", nullable = false)
    private int minPoints;

    @Column(name="max_points", nullable = false)
    private int maxPoints;

}
