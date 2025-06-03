package com.artemyakkonen.jpql;

import com.artemyakkonen.jpql.entity.Student;
import com.artemyakkonen.util.MyColor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

public class JPQLEx4 {
    private static final Logger log = LoggerFactory.getLogger(JPQLEx4.class);

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(JPQLEx1.class);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();


        try {
            transaction.begin();

            log.info(MyColor.color("First select"));
            Student student1 = entityManager.find(Student.class, 3);
            Student student2 = entityManager.find(Student.class, 3);

            log.info(MyColor.color("Second select"));
            Student student = (Student) entityManager.createQuery("select s from Student s where s.id = 3")
                    .getSingleResult();


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
