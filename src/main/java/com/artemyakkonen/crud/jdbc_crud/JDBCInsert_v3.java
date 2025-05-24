package com.artemyakkonen.crud.jdbc_crud;

import com.artemyakkonen.crud.entity.Student;

import java.sql.*;

public class JDBCInsert_v3 {
    static final String DB_URL = "jdbc:postgresql://109.120.155.136:5432/test_db";
    static final String USER = "jpauser";
    static final String PWD = "jpapwd";

    public static void main(String[] args) {
        Connection connection = null;
        Student student = new Student("Isaac", "Sharp", 9.8);

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PWD);
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO students(name, surname, avg_grade) values (?, ?, ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS
            );
            statement.setString(1, student.getName());
            statement.setString(2, student.getSurname());
            statement.setDouble(3, student.getAvgGrade());

           int affectedRows = statement.executeUpdate();
           if(affectedRows == 0){
               throw new SQLException("Failed to add Student to DB");
           }

           ResultSet generatedKeys = statement.getGeneratedKeys();
           if(generatedKeys.next()){
               student.setId(generatedKeys.getLong(1));
           }
           else{
               throw new SQLException("Failed to create student ID");
           }

            System.out.println(student);

            statement.close();
            generatedKeys.close();

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
