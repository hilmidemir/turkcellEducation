package com.turkcell;

import java.sql.SQLException;

public class Main {
  public static void main(String[] args) throws SQLException {
    InMemory imc = new InMemory();
    Student st =new Student("ahmet", "topcu",9);
    Teacher tc = new Teacher("engin","demirog","algo");
    PostgreSQLDatabase db =new PostgreSQLDatabase();
    System.out.println("------------------------------------");
    db.ekle(st.name);
    db.sil(st.name);
    System.out.println("------------------------------------");

    StudentAdd st2 = new StudentAdd("hilmi","demir");
    ListAllStudent las =new ListAllStudent();
    ListAllTeacher lat =new ListAllTeacher();
  }
}