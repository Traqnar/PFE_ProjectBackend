package com.example.kickerdavinci.Models;
import javax.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Cups")
public class Cup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long Id;

    @Column(name="name",unique = true, nullable = false)
    private String name;
    @Column(name="start_date", nullable = false)
    private LocalDate startDate;
    @Column(name="end_date", nullable = false)
    private LocalDate endDate;

    @OneToMany
    private List<Club> teams;
    @OneToMany(mappedBy = "cup")
    private List<Game> games;

}
