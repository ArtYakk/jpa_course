package com.artemyakkonen.criteria_query;

import com.artemyakkonen.criteria_query.entity.Student;
import com.artemyakkonen.util.MyColor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class CriteriaQueryEx1 {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(CriteriaQueryEx1.class);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        try {
            //1 Creation of Criteria Builder
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

            //2 Creation of Criteria Query
            CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);

            //3 Root creation
            Root<Student> root = criteriaQuery.from(Student.class);// From Student s

            //4 Adding root to Criteria Query
            criteriaQuery.select(root);// select s from Student s

            //5 Query creation
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
