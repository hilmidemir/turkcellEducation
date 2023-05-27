package com.turkcell.bootcamp.project.entities.concretes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Hibernate ORM
@Entity
@Table(name = "us_states") // Bu model databasedeki categoriesin entities i dir
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsStates {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "state_id")
  private short stateId;

  @Column(name = "state_name")
  private String stateName;

  @Column(name = "state_abbr")
  private String stateAbbr;

  @Column(name = "state_region")
  private String stateRegion;
}
