package com.turkcell.bootcamp.project.entities.concretes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

//Hibernate ORM
@Entity
@Table(name = "region") // Bu model databasedeki categoriesin entities i dir
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Region {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "region_id")
  private short regionId;

  @Column(name = "region_description")
  private char regionDescription;

  @OneToMany(mappedBy = "region")
  private List<Territory> territories;
}
