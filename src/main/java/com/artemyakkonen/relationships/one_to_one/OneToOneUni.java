package com.artemyakkonen.relationships.one_to_one;


import com.artemyakkonen.relationships.one_to_one.entity.Passport;
import com.artemyakkonen.relationships.one_to_one.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class OneToOneUni {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        Student student = null;

        try {
            transaction.begin();

            Student student1 = new Student("Leo", "Pharell", 7.1);
            Passport passport1 = new Passport("leo@gmail.com", 184, "black");
            student1.setPassport(passport1);

            entityManager.persist(passport1);
            entityManager.persist(student1);

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
            System.out.println(student);
        }
    }
}
