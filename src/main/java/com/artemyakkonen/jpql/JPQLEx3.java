package com.artemyakkonen.jpql;

import com.artemyakkonen.jpql.entity.University;
import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;


public class JPQLEx3 {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(JPQLEx3.class);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

//             Select universities without students
//            Query query = entityManager.createQuery("select u from University u " +
//                    "where u.students is empty ");
//            List<University> universities = query.getResultList();
//            System.out.println(universities);
//***********************************************************************************************************************
//             Select universities with 1 student
//            Query query = entityManager.createQuery("select u from University u " +
//                    "where size(u.students) = 1");
//            List<University> universities = query.getResultList();
//            System.out.println(universities);
//***********************************************************************************************************************
//             Sort universities by count of students DESC
//            Query query = entityManager.createQuery("select u from University u " +
//                    "order by size(u.students) desc");
//            List<University> universities = query.getResultList();
//            System.out.println(universities);
//***********************************************************************************************************************
//            Cross join
//            Query query = entityManager.createQuery("select u, s from University u, Student s");
//            List<Object[]> results = query.getResultList();
//            for (Object[] ob : results) {
//                System.out.println(ob[0] + " " + ob[1]);
//            }
//***********************************************************************************************************************
//             Join
//            Query query = entityManager.createQuery("select u, s from University u join u.students s");
//            List<Object[]> results = query.getResultList();
//            for (Object[] ob : results){
//                System.out.println(ob[0] + " " + ob[1]);
//        }

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
