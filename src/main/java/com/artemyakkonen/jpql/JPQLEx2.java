package com.artemyakkonen.jpql;

import com.artemyakkonen.jpql.entity.Student;
import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class JPQLEx2 {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(JPQLEx2.class);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

//******************************************************************************************************************
//            POSITION PARAMETERS
//            Query query = entityManager.createQuery("select s from Student s " +
//                    "where s.name like ?1 and s.avgGrade > ?2");
//            query.setParameter(1, "%l%");
//            query.setParameter(2, 8.5);
//            List<Student> students = query.getResultList();
//            System.out.println(students);
//******************************************************************************************************************
//            NAMED PARAMETERS
//            Query query = entityManager.createQuery("select s from Student s " +
//                    "where s.name like :letter and s.avgGrade > :grade");
//            query.setParameter("letter", "%l%");
//            query.setParameter("grade", 8.5);
//            List<Student> students = query.getResultList();
//            System.out.println(students);
//******************************************************************************************************************
//            UPDATE
//            Query query = entityManager.createQuery("update Student s " +
//                    "set s.avgGrade = 10 " +
//                    "where s.id = 1 ");
//            query.executeUpdate();
//******************************************************************************************************************
//            DELETE
            Query query = entityManager.createQuery("delete from Student s " +
                    "where s.avgGrade < 7.5 or s.avgGrade is null ");
            query.executeUpdate();



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
