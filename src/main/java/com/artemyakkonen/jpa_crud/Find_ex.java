package com.artemyakkonen.jpa_crud;

//import com.artemyakkonen.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.HashSet;
import java.util.Set;

public class Find_ex {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

            EntityTransaction transaction = entityManager.getTransaction();
          //  Student student = null;

            try {
                //student =

            }
            catch (Exception e){

                e.printStackTrace();
            }
            finally {
                if(entityManager != null){
                    entityManager.close();
                    factory.close();
                }
              //  System.out.println(student);
            }



    }
}
