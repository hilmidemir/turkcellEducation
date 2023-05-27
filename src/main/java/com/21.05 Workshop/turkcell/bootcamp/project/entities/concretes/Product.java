package com.turkcell.bootcamp.project.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column (name = "product_id")
  private short productId;

  @Column(name = "unit_price")
  private float unitPrice;

  @Column (name = "product_name")
  private String productName;

  @Column (name = "quantity_per_unit")
  private String quantityPerUnit;

  @Column (name = "units_in_stock")
  private short unitsInStock;

  @Column (name = "units_on_order")
  private short unitsOnOrder;

  @Column (name = "reorder_level")
  private short reorderLevel;

  @Column (name = "discontinued")
  private int discontinued;

  @OneToMany(mappedBy = "product")
  private List<OrderDetail> orderDetails;

  @ManyToOne()
  @JoinColumn(name = "category_id")
  private Category category;

  @ManyToOne
  @JoinColumn(name = "supplier_id")
  private Supplier supplier;
}
