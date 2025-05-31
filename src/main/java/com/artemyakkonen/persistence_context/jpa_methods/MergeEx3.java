package com.artemyakkonen.persistence_context.jpa_methods;

import com.artemyakkonen.persistence_context.entity.Subject;
import com.artemyakkonen.persistence_context.entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class MergeEx3 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();

            Teacher teacher = new Teacher("Zaur", "Tregulov", Subject.CHEMISTRY, true);
            // teacher.setId(100L);
            Teacher mergedTeacher = entityManager.merge(teacher);
            System.out.println(mergedTeacher);

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
