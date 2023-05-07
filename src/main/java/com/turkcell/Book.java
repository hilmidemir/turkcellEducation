package com.turkcell;

public class Book {
  private String bookName;
  private String author;

  public String getBookName() {
    return bookName;
  }

  public void setBookName(String bookName) {
    this.bookName = bookName;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Book(String bookName, String author) {
    this.bookName = bookName;
    this.author = author;
    System.out.println(this.bookName + " adlı kitap kaydedildi.");

  }
}
