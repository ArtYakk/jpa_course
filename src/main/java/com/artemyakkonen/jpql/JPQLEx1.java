package com.artemyakkonen.jpql;

import com.artemyakkonen.jpql.entity.Student;
import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class JPQLEx1 {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(JPQLEx1.class);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

//            ALL STUDENTS
//            select * from students;

//            Query query = entityManager.createQuery("select s from Student s");
//            List<Student> students = query.getResultList();
//            System.out.println(students);

//            TypedQuery<Student> query = entityManager.createQuery("select s from Student s", Student.class);
//            List<Student> students = query.getResultList();
//            System.out.println(students);

//            List<Student> students = entityManager.createQuery("select s from Student s").getResultList();
//            System.out.println(students);

//            List<Student> list = entityManager.createQuery("from Student").getResultList();
//******************************************************************************************************************
//            ALL STUDENTS WITH NAME LEO
//            List<Student> students = entityManager.createQuery("select s from Student s " +
//                    "where s.name = 'Leo'").getResultList();
//            System.out.println(students);
//******************************************************************************************************************
//            ALL STUDENTS WITH AVG GRADE > 8.5
//            List<Student> students = entityManager.createQuery("select s from Student s " +
//                    "where s.avgGrade > 8.5").getResultList();
//            System.out.println(students);
//******************************************************************************************************************
//            ALL STUDENTS WITH AVG BETWEEN 7 AND 8
            List<Student> students = entityManager.createQuery("select s from Student s " +
                    "where s.avgGrade between 7 and 8").getResultList();
            System.out.println(students);

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
