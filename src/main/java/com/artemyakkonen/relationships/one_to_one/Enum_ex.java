package com.artemyakkonen.relationships.one_to_one;


import com.artemyakkonen.relationships.one_to_one.entity.EyeColor;
import com.artemyakkonen.relationships.one_to_one.entity.Passport;
import com.artemyakkonen.relationships.one_to_one.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Enum_ex {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();


        try {
            transaction.begin();
//            PERSIST
//            Student student = new Student("Camala", "Harris", 9.4);
//            Passport passport = new Passport("camel@gmail.com", 199, EyeColor.GREEN);
//            student.setPassport(passport);
//            entityManager.persist(student);
//            FIND
            Student student = entityManager.find(Student.class, 1);
            System.out.println(student);
            System.out.println(student.getPassport().toString());


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
