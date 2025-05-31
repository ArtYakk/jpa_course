package com.artemyakkonen.persistence_context.jpa_methods;

import com.artemyakkonen.persistence_context.entity.Subject;
import com.artemyakkonen.persistence_context.entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class MergeEx2 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();

            Teacher teacher = entityManager.find(Teacher.class, 1);
            entityManager.detach(teacher);
            System.out.println(teacher);
            Teacher mergedTeacher = entityManager.merge(teacher);
            teacher.setSubject(Subject.CHEMISTRY);
            mergedTeacher.setSubject(Subject.MATHS);

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
