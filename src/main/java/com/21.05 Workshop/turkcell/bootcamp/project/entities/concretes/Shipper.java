package com.turkcell.bootcamp.project.entities.concretes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

//Hibernate ORM
@Entity
@Table(name = "shippers") // Bu model databasedeki categoriesin entities i dir
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Shipper {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "shipper_id")
  private short shipperId;

  @Column(name = "company_name")
  private String companyName;

  @Column(name = "phone")
  private String phone;

  @OneToMany(mappedBy = "shipper")
  private List<Order> orders;
}
