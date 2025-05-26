package com.artemyakkonen.relationships.one_to_many;

import com.artemyakkonen.relationships.one_to_many.entity.Student;
import com.artemyakkonen.relationships.one_to_many.entity.University;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.sql.Date;

public class OneToManyBi {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();


        try {
            transaction.begin();

            //PERSIST
//            University university = new University("MIT", Date.valueOf("1988-10-28"));
//            Student student1 = new Student("Isaac", "Sharp", 5.5);
//            Student student2 = new Student("Serena", "Nilsen", 8.2);
//            Student student3 = new Student("Pablo", "Escobar", 8.2);
//            Student student4 = new Student("Darcie", "James", 9.2);
//            university.addStudentToUniversity(student1);
//            university.addStudentToUniversity(student2);
//            university.addStudentToUniversity(student3);
//            university.addStudentToUniversity(student4);
//            entityManager.persist(university);
//            Student student3 = new Student("Sekena", "Gomez", 8.9);
//            University university = entityManager.find(University.class, 2);
//            university.addStudentToUniversity(student3);
//            entityManager.persist(student3);
            //FIND
            University university = entityManager.find(University.class, 1);
            System.out.println(university);
            System.out.println(university.getStudents());
//            Student student = entityManager.find(Student.class, 2);
//            System.out.println(student);
//            System.out.println(student.getUniversity());
//            System.out.println(student.getUniversity().getStudents());
            //REMOVE
//            Student student = entityManager.find(Student.class, 4);
//            entityManager.remove(student);

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
