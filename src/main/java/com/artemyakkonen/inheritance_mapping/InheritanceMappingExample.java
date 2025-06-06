package com.artemyakkonen.inheritance_mapping;

import com.artemyakkonen.inheritance_mapping.entity.Driver;
import com.artemyakkonen.inheritance_mapping.entity.Employee;
import com.artemyakkonen.inheritance_mapping.entity.Teacher;
import com.artemyakkonen.util.MyColor;
import jakarta.persistence.*;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class InheritanceMappingExample {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(InheritanceMappingExample.class);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();

//            Teacher teacher = new Teacher("Alessandro", 1500, 5.0, "Maths", false);
//            Driver driver = new Driver("Peter", 2300, 15d, 'B', "BMW");

//            Teacher teacher = new Teacher("Rio", 2000, 7.0, "Biology", true);
//            Driver driver = new Driver("Michael", 2800, 25d, 'C', "Mercedes");
//            entityManager.persist(teacher);
//            entityManager.persist(driver);
//
//            Query query = entityManager.createQuery("select e from Employee e", Employee.class);
//            List<Employee> employees = query.getResultList();
//            System.out.println(employees);
//
            Query query = entityManager.createQuery("select d from Driver d", Employee.class);
            List<Employee> employees = query.getResultList();
            System.out.println(employees);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            logger.info(MyColor.color("Ошибка в транзакции " + e));
        }finally {
            if (entityManager != null){
                entityManager.close();
                factory.close();
            }
        }
    }
}
