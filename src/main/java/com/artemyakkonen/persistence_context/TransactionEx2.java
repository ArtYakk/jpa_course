package com.artemyakkonen.persistence_context;

import com.artemyakkonen.persistence_context.entity.Subject;
import com.artemyakkonen.persistence_context.entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TransactionEx2 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();

            Teacher teacher1 = new Teacher("Landrick", "Shelton", Subject.CHEMISTRY, true);
            Teacher teacher2 = new Teacher("Emily", "Ratakovski", Subject.HISTORY, false);

            entityManager.persist(teacher1);
            Teacher teacher3 = entityManager.find(Teacher.class, 100);
            System.out.println(teacher3.getName() + " " + teacher3.getSurname());

            entityManager.persist(teacher2);



            transaction.commit();
        }
        catch(Exception e){
            if(transaction != null){
                System.out.println("Сработал Rollback");
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
