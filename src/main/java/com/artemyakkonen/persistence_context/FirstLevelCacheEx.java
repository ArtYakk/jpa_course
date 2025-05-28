package com.artemyakkonen.persistence_context;

import com.artemyakkonen.persistence_context.entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transaction;

public class FirstLevelCacheEx {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try{
//            transaction.begin();
            Teacher teacher1 = entityManager.find(Teacher.class, 3);
//            transaction.commit();
            entityManager.close();
//            transaction.begin();
            entityManager = factory.createEntityManager();
            Teacher teacher2 = entityManager.find(Teacher.class, 3);
//            transaction.commit();
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
