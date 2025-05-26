package com.artemyakkonen.relationships.many_to_many;

import com.artemyakkonen.relationships.many_to_many.entity.Subject;
import com.artemyakkonen.relationships.many_to_many.entity.Teacher;
import com.artemyakkonen.relationships.many_to_many.entity.University;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.sql.Date;

public class ManyToManyBi {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();



        try {
            transaction.begin();
            //PERSIST
//            University university = new University("MIT", Date.valueOf("1988-10-28"));
//            Teacher teacher1 = new Teacher("Alessandro", "Lazzano", Subject.GEOMETRY, true);
//            Teacher teacher2 = new Teacher("Rio", "Berger", Subject.MATHS, false);
//            Teacher teacher3 = new Teacher("Landry", "Shelton", Subject.HISTORY, true);
//            university.addTeacherToUniversity(teacher1);
//            university.addTeacherToUniversity(teacher2);
//            university.addTeacherToUniversity(teacher3);
//            entityManager.persist(university);
//            Teacher teacher = new Teacher("Vera", "Walton", Subject.CHEMISTRY, false);
//            University university1 = new University("Oxford", Date.valueOf("1560-05-12"));
//            University university2 = new University("Cambridge", Date.valueOf("1209-03-22"));
//            University university3 = new University("ISPU", Date.valueOf("1960-05-28"));
//            teacher.addUniversityToTeacher(university1);
//            teacher.addUniversityToTeacher(university2);
//            teacher.addUniversityToTeacher(university3);
//            entityManager.persist(teacher);
            //FIND
//            University university = entityManager.find(University.class, 1);
//            System.out.println(university);
//            System.out.println(university.getTeachers());
//            Teacher teacher = entityManager.find(Teacher.class, 4);
//            System.out.println(teacher);
//            System.out.println(teacher.getUniversities());
            //REMOVE
//            Teacher teacher = entityManager.find(Teacher.class, 4);
//            University university = entityManager.find(University.class, 1);
//            teacher.addUniversityToTeacher(university);
//            entityManager.persist(teacher);
//            Teacher teacher = entityManager.find(Teacher.class, 4);
//            entityManager.remove(teacher);
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
