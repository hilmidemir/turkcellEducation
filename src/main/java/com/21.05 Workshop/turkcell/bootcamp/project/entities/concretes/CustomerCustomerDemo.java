package com.turkcell.bootcamp.project.entities.concretes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Hibernate ORM
@Entity
@Table(name = "customer_customer_demo") // Bu model databasedeki categoriesin entities i dir
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerCustomerDemo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @ManyToOne
  @JoinColumn(name="customer_id")
  private Customer customer;

  @ManyToOne()
  @JoinColumn(name="customer_type_id")
  private CustomerDemographics customerDemographic;
}
