package com.artemyakkonen.jpql;

import com.artemyakkonen.jpql.entity.Student;
import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class NativeQueryEx {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(JPQLEx3.class);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
//
//            Query query = entityManager.createNativeQuery("select * from students", Student.class);
//            List<Student> students = query.getResultList();
//*********************************************************************************************************
            Query query = entityManager.createNativeQuery("select * from students " +
                    "where avg_grade > ?1 and length(name) = ?2", Student.class);
            query.setParameter(1, 8);
            query.setParameter(2, 5);
            List<Student> students = query.getResultList();

            System.out.println(students);
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            logger.error("Ошибка в транзакции, произведен rollback ", e);
        }finally {
            if(entityManager != null){
                entityManager.close();
                factory.close();
            }
        }
    }
}
