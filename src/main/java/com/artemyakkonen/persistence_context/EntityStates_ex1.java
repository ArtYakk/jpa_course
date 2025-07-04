package com.artemyakkonen.persistence_context;

import com.artemyakkonen.persistence_context.entity.Subject;
import com.artemyakkonen.persistence_context.entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class EntityStates_ex1 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();

            Teacher teacher1 = new Teacher("Rio", "Berger", Subject.CHEMISTRY, false);
            Teacher teacher2 = new Teacher("Lubov", "Korolkova", Subject.MATHS, true);
          //  System.out.println(entityManager.contains(teacher));
            entityManager.persist(teacher1);
            entityManager.persist(teacher2);
          //  System.out.println(entityManager.contains(teacher));

            transaction.commit();

           // System.out.println(entityManager.contains(teacher));
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
