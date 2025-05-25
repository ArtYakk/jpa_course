package com.artemyakkonen.relationships.one_to_one;


import com.artemyakkonen.relationships.one_to_one.entity.Passport;
import com.artemyakkonen.relationships.one_to_one.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class OneToOneBi {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();


        try {
            transaction.begin();

           //PERSIST
            Student student1 = new Student("Isaac", "Sharp", 9.4);
            Passport passport1 = new Passport("isaac@gmail.com", 183, "blue");
            student1.setPassport(passport1);


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
