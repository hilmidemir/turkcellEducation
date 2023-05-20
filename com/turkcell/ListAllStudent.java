package com.turkcell;

import java.sql.*;

public  class ListAllStudent {
  // Veri sorgulama
  public ListAllStudent() throws SQLException {

    Connection connection = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery("SELECT * FROM Students");

    while (resultSet.next()) {
      String name = resultSet.getString("name");
      String surname = resultSet.getString("surname");
      System.out.println("Student name: " + name + " Student surname: " + surname);
    }


    resultSet.close();
    statement.close();
    connection.close();
  }
}
