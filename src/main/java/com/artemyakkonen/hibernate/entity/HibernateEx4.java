package com.artemyakkonen.hibernate.entity;

import com.artemyakkonen.util.MyColor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateEx4 {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(HibernateEx4.class);
        SessionFactory sessionFactory  = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.getTransaction();
        try{
            transaction.begin();

            Student student = session.get(Student.class, 2);

            session.remove(student);


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
