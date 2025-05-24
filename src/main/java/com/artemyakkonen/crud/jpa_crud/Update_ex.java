package com.artemyakkonen.crud.jpa_crud;

import com.artemyakkonen.crud.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Update_ex {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        Student student = null;
        try {
            transaction.begin();

            student = entityManager.find(Student.class, 9);
            student.setAvgGrade(10.0);

            transaction.commit();
        }
        catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            if(entityManager != null) {
                entityManager.close();
                factory.close();
            }// 9 Selena

            System.out.println(student);
        }
    }
}
