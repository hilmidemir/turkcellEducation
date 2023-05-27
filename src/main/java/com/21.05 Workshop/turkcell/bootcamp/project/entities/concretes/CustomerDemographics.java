package com.turkcell.bootcamp.project.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

//Hibernate ORM
@Entity
@Table(name = "customer_demographics") // Bu model databasedeki categoriesin entities i dir
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDemographics {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "customer_type_id")
  private char customerTypeId;

  @Column(name = "customer_desc")
  private String customerDesc;

  @OneToMany(mappedBy= "customerDemographic")
  private List<CustomerCustomerDemo> customerCustomerDemos;
}
