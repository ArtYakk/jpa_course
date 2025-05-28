package com.artemyakkonen.persistence_context;

import com.artemyakkonen.persistence_context.entity.Subject;
import com.artemyakkonen.persistence_context.entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class AutomaticDirtyCheckingEx2 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try{

            Teacher teacher = entityManager.find(Teacher.class, 4);
            entityManager.close();

            entityManager = factory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            teacher.setSubject(Subject.HISTORY);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            if (entityManager != null){
                entityManager.close();
                factory.close();
            }
        }
    }
}
