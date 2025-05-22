package com.artemyakkonen;

import java.sql.*;
import java.util.Scanner;

public class JDBCUpdate {
    static final String DB_URL = "jdbc:postgresql://109.120.155.136:5432/test_db";
    static final String USER = "jpauser";
    static final String PWD = "jpapwd";

    public static void main(String[] args) {
        Connection connection = null;
        Student student = new Student("Pharell", "Williams", 8.2);


        try {
            connection = DriverManager.getConnection(DB_URL, USER, PWD);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter name:");
            String enteredName = scanner.nextLine();

//            Statement statement = connection.createStatement();
//            String sqlQuery = "UPDATE students " +
//                    "SET avg_grade = 9.5 " +
//                    "WHERE name = '" + enteredName + "'" ;
//
//            statement.executeUpdate(sqlQuery);
//
//            statement.close();

            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE students SET avg_grade = 6.3 WHERE name = ?"
            );
            statement.setString(1, enteredName);
            statement.executeUpdate();

            statement.close();

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
