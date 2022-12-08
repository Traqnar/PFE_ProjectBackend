package com.example.kickerdavinci.Models;

import javax.persistence.*;
import lombok.*;
import java.util.List;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Sets")
public class Set {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long Id;
    @ManyToOne
    @JoinColumn(name = "GAME_RECAP_ID", referencedColumnName = "ID")
    private GameRecap gameRecap;

    @Column(name = "num",nullable = false)
    private int num;

    @OneToOne
    @JoinColumn(name ="HOST_PLAYER_1_ID",referencedColumnName="ID", nullable = false)
    private User hostPlayer1;
    @OneToOne
    @JoinColumn(name ="HOST_PLAYER_2_ID",referencedColumnName="ID", nullable = false)
    private User hostPlayer2;
    @OneToOne
    @JoinColumn(name ="GUEST_PLAYER_1_ID",referencedColumnName="ID", nullable = false)
    private User guestPlayer1;
    @OneToOne
    @JoinColumn(name ="GUEST_PLAYER_2_ID",referencedColumnName="ID", nullable = false)
    private User guestPlayer2;
    @OneToOne
    @JoinColumn(name ="HOST_RESERVE_1_ID",referencedColumnName="ID")
    private User hostReserve1;
    @OneToOne
    @JoinColumn(name ="HOST_RESERVE_2_ID",referencedColumnName="ID")
    private User hostReserve2;
    @OneToOne
    @JoinColumn(name ="GUEST_RESERVE_1_ID",referencedColumnName="ID")
    private User guestReserve1;
    @OneToOne
    @JoinColumn(name ="GUEST_RESERVE_2_ID",referencedColumnName="ID")
    private User guestReserve2;
}
