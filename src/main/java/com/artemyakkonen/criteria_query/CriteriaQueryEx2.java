package com.artemyakkonen.criteria_query;

import com.artemyakkonen.criteria_query.entity.Student;
import com.artemyakkonen.util.MyColor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class CriteriaQueryEx2 {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(CriteriaQueryEx2.class);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        try {
//            // JPQL: select s.name from Student s
//
//            //1 Creation of Criteria Builder
//            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//
//            //2 Creation of Criteria Query
//            CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
//
//            //3 Root creation
//            Root<Student> root = criteriaQuery.from(Student.class);// From Student s
//
//            //4 Adding root to Criteria Query
//            criteriaQuery.select(root.get("name"));// select s.name from Student s
//
//            //5 Query creation
//            TypedQuery<String> query = entityManager.createQuery(criteriaQuery);
//
//            List<String> students = query.getResultList();
//            System.out.println(students);

//*******************************************************************************************************************
//            JPQL: select s from Student s where avgGrade >= 7.5
            //1
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

            //2
            CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);

            //3
            Root<Student> root = criteriaQuery.from(Student.class);

            //3.1 Condition creation
            Predicate predicate = criteriaBuilder.greaterThanOrEqualTo(root.get("avgGrade"), 7.5);

            //3.2 Adding condition to Criteria Query
            criteriaQuery.where(predicate);

            //4
            criteriaQuery.select(root); // select s from Student s where s.avgGrade >= 7.5

            //5
            TypedQuery<Student> query = entityManager.createQuery(criteriaQuery);


            List<Student> students = query.getResultList();
            System.out.println(students);

        }catch (Exception e){
            logger.error(MyColor.color("Ошибка при работе с persistence " + e));
        }finally {
            if(entityManager != null){
                entityManager.close();
                factory.close();
            }
        }
    }
}
