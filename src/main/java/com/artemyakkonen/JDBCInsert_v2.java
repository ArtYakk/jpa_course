package com.artemyakkonen;

import java.sql.*;

public class JDBCInsert_v2 {
    static final String DB_URL = "jdbc:postgresql://109.120.155.136:5432/test_db";
    static final String USER = "jpauser";
    static final String PWD = "jpapwd";

    public static void main(String[] args) {
        Connection connection = null;
        Student student = new Student("Pharell", "Williams", 8.2);


        try {
            connection = DriverManager.getConnection(DB_URL, USER, PWD);
            Statement statement = connection.createStatement();

            String sqlQuery = "INSERT INTO students(name, surname, avg_grade) values " +
                    "('" +
                    student.getName() +
                    "', '" +
                    student.getSurname() +
                    "', " +
                    student.getAvgGrade() +
                    ")";

            statement.executeUpdate(sqlQuery);

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
