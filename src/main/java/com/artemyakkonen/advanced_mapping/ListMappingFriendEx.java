package com.artemyakkonen.advanced_mapping;

import com.artemyakkonen.advanced_mapping.entity.Employee;
import com.artemyakkonen.advanced_mapping.entity.Friend;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class ListMappingFriendEx {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();
//            List<Friend> friends = new ArrayList<>();
//            Friend friend1 = new Friend("Yarvis", "Zhgilev", 24);
//            Friend friend2 = new Friend("Vel", "Remshuev", 25);
//            Friend friend3 = new Friend("Volodya", "Melch", 25);
//            friends.add(friend1);
//            friends.add(friend2);
//            friends.add(friend3);
//            Employee employee = new Employee("Artem", 2000, 3.0, friends);
//            entityManager.persist(employee);
            Employee employee = entityManager.find(Employee.class, 252);
            System.out.println(employee);

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
