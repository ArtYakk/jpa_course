package com.artemyakkonen.hibernate;

import com.artemyakkonen.hibernate.entity.Student;
import com.artemyakkonen.util.MyColor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class HQLEx {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(HQLEx.class);
        SessionFactory sessionFactory  = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.getTransaction();
        try{
            transaction.begin();

//            ALL STUDENTS
//            select * from students;
//            Query<Student> query = session.createQuery("from Student", Student.class);
//            List<Student> students = query.getResultList();
//            students.forEach(System.out::println);
//            ALL Students where name with 'l' or 'L' and grade > 8
//            List<Student> students = session.createQuery("from Student s " +
//                    "where lower(s.name) like '%l%' and s.avgGrade > 8", Student.class).getResultList();
//            students.forEach(System.out::println);
//            UPDATE
//           session.createQuery("update Student s " +
//                    "set avgGrade = 10.0 " +
//                    "where length(name) = 5").executeUpdate();
//            DELETE
//            session.createQuery("""
//                                     delete from Student s
//                                     where s.avgGrade < 9
//""").executeUpdate();

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
