package com.artemyakkonen.jpql;

import com.artemyakkonen.jpql.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlushEx {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(JPQLEx1.class);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            Student student = entityManager.find(Student.class, 1);
            student.setAvgGrade(9.0);


            Double avgGrade = (Double)entityManager.createQuery("select  s.avgGrade from Student s where s.id = 1").getSingleResult();
            System.out.println(avgGrade);

            transaction.commit();
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
