package com.artemyakkonen.persistence_context;

import com.artemyakkonen.persistence_context.entity.Subject;
import com.artemyakkonen.persistence_context.entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Transaction_ex1 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();

            Teacher teacher1 = entityManager.find(Teacher.class, 3);
            Teacher teacher2 = entityManager.find(Teacher.class, 4);

            teacher1.setSubject(Subject.HISTORY);

            Teacher teacher3 = entityManager.find(Teacher.class, 7);
            System.out.println(teacher3.isProfessor());

            teacher2.setSubject(Subject.HISTORY);

       //     entityManager.persist(teacher1);
         //   entityManager.persist(teacher2);


            transaction.commit();
        }
        catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally{
            if(entityManager != null){
                entityManager.close();
                factory.close();
            }
        }
    }
}
