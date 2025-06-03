package com.artemyakkonen.criteria_query;

import com.artemyakkonen.criteria_query.entity.Student;
import com.artemyakkonen.criteria_query.entity.University;
import com.artemyakkonen.util.MyColor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class CriteriaQueryEx3 {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(CriteriaQueryEx3.class);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        try {
//            // JPQL: select s.name, s.avgGrade from Student s
//            //1 Creation of Criteria Builder
//            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//            //2 Creation of Criteria Query
//            CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
//            //3 Root creation
//            Root<Student> root = criteriaQuery.from(Student.class);// From Student s
//            //4 Adding root to Criteria Query
//            criteriaQuery.multiselect(root.get("name"), root.get("avgGrade"));// select s.name from Student s
//            //5 Query creation
//            TypedQuery<Object[]> query = entityManager.createQuery(criteriaQuery);
//            List<Object[]> students = query.getResultList();
//            for(Object[] ob : students){
//                System.out.println(ob[0] + " " + ob[1]);
//            }
//*******************************************************************************************************************

            // JPQL: select u, s from University u join u.students s
            //1 Creation of Criteria Builder
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

            //2 Creation of Criteria Query
            CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);

            //3 Root creation
            Root<University> root = criteriaQuery.from(University.class);// From Student s

            //3.1 JOIN
            Join<University, Student> join = root.join("students");

            //4 Adding root to Criteria Query
            criteriaQuery.multiselect(root, join);// select u, s from University u join
                                                  // u.students s
            //5 Query creation
            TypedQuery<Object[]> query = entityManager.createQuery(criteriaQuery);
            List<Object[]> students = query.getResultList();
            for(Object[] ob : students){
                System.out.println(ob[0] + " " + ob[1]);
            }

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
