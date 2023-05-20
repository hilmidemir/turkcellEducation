package com.turkcell;

import java.sql.*;

public class ListAllTeacher {
  public ListAllTeacher() throws SQLException {

    Connection connection = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery("SELECT * FROM Teacher");

    while (resultSet.next()) {
      String name = resultSet.getString("name");
      String surname = resultSet.getString("surname");
      System.out.println("Teacher name: " + name + " Teacher surname: " + surname);
    }


    resultSet.close();
    statement.close();
    connection.close();
  }
}