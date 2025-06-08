package com.artemyakkonen.advanced_mapping;

import com.artemyakkonen.advanced_mapping.entity.Book;
import com.artemyakkonen.advanced_mapping.entity.Employee;
import com.artemyakkonen.advanced_mapping.entity.id.BookId;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CompoundPrimaryKeyEx {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();

//            Book book1 = new Book("Dosto", "Crime and P", 1866, 4.8);
//            Book book2 = new Book("Dosto", "The brothers K", 1880, 4.6);
//            Book book3 = new Book("Tolstoy", "War and P", 1867, 4.7);
//
//            entityManager.persist(book1);
//            entityManager.persist(book2);
//            entityManager.persist(book3);

            Book book = entityManager.find(Book.class, new BookId("Dosto", "Crime and P"));
            System.out.println(book);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            if(entityManager != null){
                entityManager.close();
                factory.close();
            }

        }
    }
}
