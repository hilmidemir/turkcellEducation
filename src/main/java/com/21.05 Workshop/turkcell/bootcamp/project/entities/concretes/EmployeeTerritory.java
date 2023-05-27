package com.turkcell.bootcamp.project.entities.concretes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Hibernate ORM
@Entity
@Table(name = "employee_territories") // Bu model databasedeki categoriesin entities'i dir
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeTerritory {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @ManyToOne()
  @JoinColumn(name = "employee_id")
  private Employee employee;

  @ManyToOne
  @JoinColumn(name = "territory_id")
  private Territory territory;
}
