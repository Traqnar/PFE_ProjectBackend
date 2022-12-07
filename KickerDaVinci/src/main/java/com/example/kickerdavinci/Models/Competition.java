package com.example.kickerdavinci.Models;
import javax.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Competitions")
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long Id;

    @Column(name="date", nullable = false, unique = true)
    private LocalDate date;

    @Column(name="max_slots", nullable = false)
    private int maxSlots;

    @Column(name="note")
    private String note;

}
