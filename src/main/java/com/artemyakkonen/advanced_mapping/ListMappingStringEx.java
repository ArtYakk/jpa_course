package com.artemyakkonen.advanced_mapping;

import com.artemyakkonen.advanced_mapping.entity.Address;
import com.artemyakkonen.advanced_mapping.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class ListMappingStringEx {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();

            List<String> friendsNames = new ArrayList<>();
            friendsNames.add("Roy");
            friendsNames.add("Kynlee");
            friendsNames.add("Eric");

            Employee employee1 = new Employee("Rudlof", 3500, 10d, friendsNames);

            entityManager.persist(employee1);

//            Employee employee = entityManager.find(Employee.class, 52);
//            System.out.println(employee);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            if(entityManager != null){
                entityManager.close();
                factory.close();
            }

        }
    }
}
