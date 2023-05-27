package com.turkcell.bootcamp.project.entities.concretes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

//Hibernate ORM
@Entity
@Table(name = "territories") // Bu model databasedeki categoriesin entities i dir
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Territory {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // why we change auto to Identity
  @Column(name = "territory_id")
  private String territoryId;

  @Column(name = "territory_description")
  private char territoryDescription;

  @OneToMany(mappedBy = "territory")
  private List<EmployeeTerritory> EmployeeTerritories;

  @ManyToOne()
  @JoinColumn(name = "region_id")
  private Region region;
  }
