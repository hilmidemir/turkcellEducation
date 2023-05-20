package com.turkcell;

import java.sql.*;

public class StudentAdd {
  public StudentAdd(String name,String surname) throws SQLException
  {
    System.out.println(name+" isimli kişi inmemorydb ye eklendi");
    PreparedStatement preparedStatement = null;

    Connection connection = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
    Statement statement = connection.createStatement();
    String insertQuery="INSERT INTO Students (name, surname) VALUES (?, ?)";
    preparedStatement = connection.prepareStatement(insertQuery);
    preparedStatement.setString(1, name);
    preparedStatement.setString(2, surname);
    preparedStatement.executeUpdate();

    connection.close();
    statement.close();
    preparedStatement.close();
  }
}
