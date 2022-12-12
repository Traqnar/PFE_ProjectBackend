package com.example.kickerdavinci.Models;

import java.util.List;
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
@Entity(name = "Clubs")
public class Club {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long Id;

  @Column(name = "name", unique = true, nullable = false)
  private String name;
  @Column(name = "local", nullable = false)
  private String local;
  @Column(name = "adress", nullable = false)
  private String adresse;
  @Column(name = "phone", nullable = false)
  private String phone;
  @Column(name = "captain_phone", nullable = false)
  private String captainPhone;
  @Column(name = "divison_points")
  private int divisionPoints;

  @OneToOne
  @JoinColumn(name = "DIVISION_ID")
  private Division division;

  @OneToOne
  @JoinColumn(name = "USER_ID")
  private User captain;

  @OneToMany(mappedBy = "club")
  private List<User> players;


}