package com.turkcell.bootcamp.project.entities.concretes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

//Hibernate ORM
@Entity
@Table(name = "suppliers") // Bu model databasedeki categoriesin entities'i dir
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="supplier_id")
  private short supplierId;

  @Column(name="company_name")
  private String companyName;

  @Column(name="contact_name")
  private String contactName;

  @Column(name = "contact_title")
  private String contactTitle;

  @Column(name="address")
  private String address;

  @Column(name="city")
  private String city;

  @Column(name="region")
  private String region;

  @Column(name="postal_code")
  private String postalCode;

  @Column(name="country")
  private String Country;

  @Column(name="phone")
  private String phone;

  @Column(name="fax")
  private String fax;

  @Column(name="homepage")
  private String homepage;

  @OneToMany(mappedBy = "supplier")
  private List<Product> products;
}
