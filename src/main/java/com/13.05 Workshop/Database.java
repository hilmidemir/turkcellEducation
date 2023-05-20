package com.turkcell;

import java.sql.*;

public class Database {
//  public static void main(String[] args) throws SQLException {
//    // H2 In-Memory veritabanı bağlantısı oluşturma
//    Connection connection = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
//
//    // Tablo oluşturma
//    Statement statement = connection.createStatement();
//    statement.executeUpdate("CREATE TABLE users (id INT PRIMARY KEY, name VARCHAR(50))");
//
//    // Data adding
//    statement.executeUpdate("INSERT INTO users (id, name) VALUES (1, 'Fenasi')");
//    statement.executeUpdate("INSERT INTO users (id, name) VALUES (2, 'Kerim')");
//
//    // Data query
//    ResultSet resultSet = statement.executeQuery("SELECT FROM users");
//    while (resultSet.next()) {
//      int id = resultSet.getInt("id");
//      String name = resultSet.getString("name");
//      System.out.println("ID: " + id + ", Name: " + name);
//    }
//
//    // Bağlantıyı kapatma
//    resultSet.close();
//    statement.close();
//    connection.close();
//  }
}