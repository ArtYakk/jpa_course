package com.artemyakkonen.hibernate;

import com.artemyakkonen.hibernate.entity.Student;
import com.artemyakkonen.util.MyColor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateEx {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(HibernateEx.class);
        SessionFactory sessionFactory  = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.getTransaction();
        try{
            Student student = new Student("Harry", "Potter", 9.8);
            transaction.begin();

            session.persist(student);
            System.out.println(student);

            Thread.sleep(8000);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            logger.error(MyColor.color("Ошибка в транзакции: " + e));
        }finally {
            if(session != null){
                session.close();
            }
            sessionFactory.close();
        }
    }
}
