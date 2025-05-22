package com.artemyakkonen.jpa_crud;

import com.artemyakkonen.jdbc_crud.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Persist_ex {
    public static void main(String[] args) {
        try (EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("jpa-course")) {
            EntityManager entityManager = factory.createEntityManager();

            EntityTransaction transaction = entityManager.getTransaction();
            Student student = null;

            try {
                transaction.begin();
                student = new Student("Chanel", "King",9.1);
                entityManager.persist(student);
                transaction.commit();
            }
            catch (Exception e){
                if(transaction != null){
                    transaction.rollback();
                }
                e.printStackTrace();
            }
            finally {
                entityManager.close();
            }
        }


    }
}
