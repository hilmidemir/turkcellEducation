package com.turkcell.bootcamp.project.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

//Hibernate ORM
@Entity
@Table(name = "categories") // Bu model databasedeki categoriesin entities i dir
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "category_id")
  private short categoryId;

  @Column(name = "category_name")
  private String categoryName;

  @Column(name = "description")
  private String description;

  @Column(name = "picture")
  private byte[] picture;

  @OneToMany(mappedBy = "category")
  private List<Product> products;
}
