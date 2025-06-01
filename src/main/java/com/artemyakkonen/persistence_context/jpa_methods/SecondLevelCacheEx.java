package com.artemyakkonen.persistence_context.jpa_methods;

import com.artemyakkonen.persistence_context.entity.Subject;
import com.artemyakkonen.persistence_context.entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class SecondLevelCacheEx {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");


        try{
            EntityManager entityManager1 = factory.createEntityManager();
            System.out.println("FIRST TIME");
            Teacher teacher1 = entityManager1.find(Teacher.class, 1);
            System.out.println(teacher1);
            entityManager1.close();

            EntityManager entityManager2 = factory.createEntityManager();
            System.out.println("SECOND TIME");
            Teacher teacher2 = entityManager2.find(Teacher.class, 1);
            System.out.println(teacher2);
            entityManager2.close();

        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            factory.close();
        }
    }
}
