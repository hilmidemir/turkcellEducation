package com.turkcell;

public class Teacher {
  private String name;

  public Teacher(String name) {
    this.name = name;
    System.out.println(this.name + " adlı hocamız kaydedildi.");
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void rentBook(Student student, Book book1) {
    System.out.println(student.getName() + " adlı öğrenciye " + this.name + " hocamız " + book1.getBookName() + " kitabını kiraladı");
  }
}
