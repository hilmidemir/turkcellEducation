package com.turkcell;

import java.sql.*;

public class InMemory {

  public InMemory() throws SQLException {
    // H2 In-Memory veritabanı bağlantısı oluşturma
    Connection connection = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
    // Tablo oluşturma
    Statement statement = connection.createStatement();

    statement.executeUpdate("CREATE TABLE Students (name VARCHAR(50) , surname VARCHAR(50))");
    statement.executeUpdate("CREATE TABLE Teacher (name VARCHAR(50) , surname VARCHAR(50))");

  }

}
