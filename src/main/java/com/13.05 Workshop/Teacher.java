package com.turkcell;

import lombok.*;

import java.sql.SQLException;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher extends Human{

  private String lessonName;

  public Teacher(String name, String surname, String lessonName) throws SQLException {
    super(name, surname);
    TeacherAdd tc = new TeacherAdd(name,surname,lessonName);
    this.lessonName = lessonName;
  }
}