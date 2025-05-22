package com.artemyakkonen.jdbc_crud;

import com.artemyakkonen.entity.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCInsert {
    static final String DB_URL = "jdbc:postgresql://109.120.155.136:5432/test_db";
    static final String USER = "jpauser";
    static final String PWD = "jpapwd";

    public static void main(String[] args) {
        Connection connection = null;
        Student student = new Student("Chanel", "King", 9.1);

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PWD);
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO students(name, surname, avg_grade) values (?, ?, ?)"
            );
            statement.setString(1, student.getName());
            statement.setString(2, student.getSurname());
            statement.setDouble(3, student.getAvgGrade());

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
