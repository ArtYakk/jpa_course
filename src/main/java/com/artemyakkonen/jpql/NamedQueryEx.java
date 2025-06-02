package com.artemyakkonen.jpql;

import com.artemyakkonen.jpql.entity.Student;
import com.artemyakkonen.jpql.entity.University;
import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class NamedQueryEx {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(JPQLEx3.class);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {

//            Query query = entityManager.createNamedQuery("University.allUniversitiesLessOrEqualTo2");
//            List<University> universities = query.getResultList();
//            System.out.println(universities);

            Query query = entityManager.createNamedQuery("University.studentsWithAvgGradeBetween");
            query.setParameter("from", 6);
            query.setParameter("to", 8);
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
