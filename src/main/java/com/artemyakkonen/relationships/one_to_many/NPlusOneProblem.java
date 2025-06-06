package com.artemyakkonen.relationships.one_to_many;

import com.artemyakkonen.relationships.one_to_many.entity.Student;
import com.artemyakkonen.relationships.one_to_many.entity.University;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

public class NPlusOneProblem {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();


        try {
            transaction.begin();

//            University university1 = new University("Harvard", Date.valueOf("1980-10-25"));
//            University university2 = new University("MIT", Date.valueOf("1961-04-14"));
//            University university3 = new University("Stenford", Date.valueOf("1970-12-01"));
//
//            Student student1 = new Student("Chanel", "King", 9.3);
//            Student student2 = new Student("Leo", "Pharell", 6.4);
//            Student student3 = new Student("Julia", "Dean", 8.7);
//
//            university1.addStudentToUniversity(student1);
//            university2.addStudentToUniversity(student2);
//            university3.addStudentToUniversity(student3);
//
//            entityManager.persist(university1);
//            entityManager.persist(university2);
//            entityManager.persist(university3);

            Query query =entityManager.createQuery("select s from Student s join fetch s.university u");
            List<Student> students = query.getResultList();

            for (Student student : students){
                System.out.println(student.getName() + " " + student.getUniversity().getName());
            }


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
