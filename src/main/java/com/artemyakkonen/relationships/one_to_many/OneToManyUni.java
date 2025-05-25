package com.artemyakkonen.relationships.one_to_many;

import com.artemyakkonen.relationships.one_to_many.entity.Student;
import com.artemyakkonen.relationships.one_to_many.entity.University;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.sql.Date;

public class OneToManyUni {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();


        try {
            transaction.begin();

//            PERSIST
//            University university = new University("Harvard",
//                    Date.valueOf("1636-10-28"));
//            Student student1 = new Student("Roy", "Harper", 7.8);
//            Student student2 = new Student("Selena", "Gomez", 9.5);
//            university.addStudentToUniversity(student1);
//            university.addStudentToUniversity(student2);
//            entityManager.persist(university);
            //FIND
//            University university = entityManager.find(University.class, 1);
//            System.out.println(university);
//            System.out.println(university.getStudents());
            //REMOVE
//            University university = entityManager.find(University.class, 1);
//            Student student3 = new Student("Scarlette", "Fox", 6.4);
//            university.addStudentToUniversity(student3);

//            Student student = entityManager.find(Student.class, 3);
//            entityManager.remove(student);

            University university = entityManager.find(University.class, 1);
            entityManager.remove(university);

            transaction.commit();
        }
        catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            if(entityManager != null){
                entityManager.close();
                factory.close();
            }
            //System.out.println(student);
        }
    }
}
