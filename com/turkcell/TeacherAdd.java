package com.turkcell;

import java.sql.*;

public class TeacherAdd {
  public TeacherAdd(String name, String surname, String lessonName) throws SQLException
  {
    System.out.println(name+" isimli kişi inmemorydb ye eklendi");
    PreparedStatement preparedStatement = null;

    Connection connection = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
    Statement statement = connection.createStatement();
    String insertQuery="INSERT INTO Teacher (name, surname) VALUES (?, ?)";
    preparedStatement = connection.prepareStatement(insertQuery);
    preparedStatement.setString(1, name);
    preparedStatement.setString(2, surname);
    preparedStatement.executeUpdate();

    connection.close();
    statement.close();
    preparedStatement.close();
  }
}
