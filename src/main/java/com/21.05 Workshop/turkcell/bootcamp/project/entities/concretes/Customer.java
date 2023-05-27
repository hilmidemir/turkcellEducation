package com.turkcell.bootcamp.project.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

//Hibernate ORM
@Entity
@Table(name = "customers") // Bu model databasedeki categoriesin entities i dir
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
  @Id
  @Column(name = "customer_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private char customerId;

  @Column (name = "contact_name")
  private String contactName;

  @Column (name = "contact_title")
  private String contactTitle;

  @Column (name = "address")
  private String address;

  @Column (name = "city")
  private String city;

  @Column (name = "region")
  private String region;

  @Column (name = "postal_code")
  private String postalCode;

  @Column (name = "country")
  private String country;

  @Column (name = "phone")
  private String phone;

  @Column (name = "fax")
  private String fax;

  @OneToMany(mappedBy = "customer")
  private List<Order> orders;

  @OneToMany(mappedBy= "customer")
  private List<CustomerCustomerDemo> customerCustomerDemos;
}
