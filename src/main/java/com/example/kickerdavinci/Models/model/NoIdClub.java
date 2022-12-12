package com.example.kickerdavinci.Models.model;

import com.example.kickerdavinci.Models.Club;
import com.example.kickerdavinci.Models.Division;
import com.example.kickerdavinci.Models.User;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NoIdClub {

  private String name;
  private String local;
  private String adresse;
  private String phone;
  private String captainPhone;
  private Division division;
  private User captain;
  private List<User> players;

  public Club toClub() {
    return new Club(0L, name, local, adresse, phone, captainPhone, 0, division,
        captain, new ArrayList<User>());
  }
}
