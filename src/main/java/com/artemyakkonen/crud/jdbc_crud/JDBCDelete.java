package com.artemyakkonen.crud.jdbc_crud;

import java.sql.*;

public class JDBCDelete {
    static final String DB_URL = "jdbc:postgresql://109.120.155.136:5432/test_db";
    static final String USER = "jpauser";
    static final String PWD = "jpapwd";

    public static void main(String[] args) {
        Connection connection = null;


        try {
            connection = DriverManager.getConnection(DB_URL, USER, PWD);

            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM students WHERE surname = ?"
            );
            statement.setString(1, "Tregulov");
           int deletedRows =  statement.executeUpdate();

           System.out.println("deleted rows: " + deletedRows);
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
