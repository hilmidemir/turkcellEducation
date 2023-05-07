package com.turkcell;

public class Student {
//  private int number;
//  private String name;
//
//  //Encapsulation
//  public int getNumber() {
//    return number;
//  }
//
//  public void setNumber(int number) {
//    this.number = number;
//  }
//
//  public String getName() {
//    return name;
//  }
//
//  public void setName(String name) {
//    this.name = name;
//  }
//
//  public Student() {
//    System.out.println("Bir öğrenci örneği oluşturuldu!");
//  }
//
//  public Student(int number, String name) {
//    System.out.println("Numara ve ismi bilinen bir öğrenci oluşturuldu");
//    this.number = number;
//    this.name = name;
  private int number;
  private String name;

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void rentBook(String bookName) {
    System.out.println(bookName + " kitabını " + this.name + " kiraladı.");
  }

  public void deliverBook(String bookName) {
    System.out.println(bookName + " kitabını " + this.name + " teslim etti");
  }

  public Student(String name, int number) {
    this.name = name;
    this.number = number;
    System.out.println(this.name + " adlı öğrenci kaydedildi.");
  }

  //  public void joinClass(String className) {
//    System.out.println(name + " isimli öğrenci " + className + " isimli derse katıldı...");
//  }
}
