package com.artemyakkonen.persistence_context.jpa_methods;

import com.artemyakkonen.persistence_context.entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ClearEx1 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();

            Teacher teacher1 = entityManager.find(Teacher.class, 1);
            Teacher teacher2 = entityManager.find(Teacher.class, 3);
            System.out.println(entityManager.contains(teacher1));
            System.out.println(entityManager.contains(teacher2));

            entityManager.clear();

            System.out.println(entityManager.contains(teacher1));
            System.out.println(entityManager.contains(teacher2));

            teacher1.setProfessor(false);
            teacher2.setProfessor(false);

            transaction.commit();
        }
        catch(Exception e){
            if(transaction != null){
                System.out.println("!!!ROLLBACK!!!");
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
