package com.turkcell;

import java.sql.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Student extends Human{

  private int studentId;

  public Student(int studentId) {
    this.studentId = studentId;
  }

  public Student(String name, String surname, int studentId) throws SQLException {
    super(name, surname);
    StudentAdd st1 =new StudentAdd(name,surname);
    this.studentId = studentId;
  }


}
