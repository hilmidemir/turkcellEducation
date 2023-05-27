package com.turkcell.bootcamp.project.entities.concretes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

//Hibernate ORM
@Entity
@Table(name = "orders") // Bu model databasedeki categoriesin entities i dir
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "order_id")
  private short orderId;

  @Column(name = "order_date")
  private LocalDate orderDate;

  @Column(name = "required_date")
  private LocalDate requiredDate;

  @Column(name = "shipped_date")
  private LocalDate shippedDate;

  @Column(name = "freight")
  private float freight;

  @Column(name = "ship_name")
  private String shipName;

  @Column(name = "ship_address")
  private String shipAddress;

  @Column(name = "ship_city")
  private String shipCity;

  @Column(name = "ship_region")
  private String shipRegion;

  @Column(name = "ship_postal_code")
  private String shipPostalCode;

  @Column(name = "ship_country")
  private String shipCountry;

  @ManyToOne()
  @JoinColumn(name = "ship_via")
  private Shipper shipper;

  @ManyToOne()
  @JoinColumn(name = "customer_id")
  private Customer customer;

  @ManyToOne()
  @JoinColumn(name = "employee_id")
  private Employee employee;

  @OneToMany(mappedBy = "order")
  private List<OrderDetail> orderDetails;

}
