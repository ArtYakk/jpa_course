package com.artemyakkonen.relationships.one_to_many;

import com.artemyakkonen.relationships.one_to_many.entity.University;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class LoadingTypes_ex {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();


        try {
            University university = entityManager.find(University.class, 1);
            System.out.println("University INFO");
            System.out.println(university);
            university.getStudents().size();
            entityManager.close();
            System.out.println("Students INFO");
            System.out.println(university.getStudents());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(entityManager != null){
              //  entityManager.close();
                factory.close();
            }
            //System.out.println(student);
        }
    }
}
