package com.artemyakkonen.persistence_context.jpa_methods;

import com.artemyakkonen.persistence_context.entity.Subject;
import com.artemyakkonen.persistence_context.entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class FlushEx1 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();

//            Teacher teacher1 = new Teacher("Alessandro", "Lazano", Subject.CHEMISTRY, true);
//            Teacher teacher2 = new Teacher("Nikolo", "Kapuletti", Subject.HISTORY, false);
//            Teacher teacher3 = new Teacher("Frederico", "Injesta", Subject.MATHS, false);
//
//            entityManager.persist(teacher1);
//            entityManager.persist(teacher2);
//            entityManager.persist(teacher3);

            Teacher teacher1 = entityManager.find(Teacher.class, 1);
            Teacher teacher3 = entityManager.find(Teacher.class, 3);


            teacher1.setSubject(Subject.CHEMISTRY);
            entityManager.flush();
            teacher3.setSubject(Subject.CHEMISTRY);

            Teacher teacherX = entityManager.find(Teacher.class, 1000);
            System.out.println(teacherX.getName());

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
