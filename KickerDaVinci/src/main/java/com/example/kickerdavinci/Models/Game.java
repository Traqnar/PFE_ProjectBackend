package com.example.kickerdavinci.Models;

import lombok.*;
import javax.persistence.*;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long Id;

    @OneToOne
    @JoinColumn(name = "CLUB_HOST_ID", nullable = false)
    private Club hostClub;

    @OneToOne
    @JoinColumn(name="CLUB_GUEST_ID", nullable = false)
    private Club guestClub;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="COMPETITION_ID")
    private Competition competition;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUP_ID")
    private Cup cup;
}
