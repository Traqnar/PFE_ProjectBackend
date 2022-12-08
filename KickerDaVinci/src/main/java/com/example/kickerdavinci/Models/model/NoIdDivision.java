package com.example.kickerdavinci.Models.model;

import com.example.kickerdavinci.Models.Division;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NoIdDivision {

  private String name;

  public Division toDivision() {
    return new Division(0L, name);
  }

}
