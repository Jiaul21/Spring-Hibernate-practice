package org.example.HQL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Criteria {
    public static void main(String[] args) {
        School s1=new School(1,"Mahigonj school","High",500,"Mahigonj");
        School s2=new School(2,"Mohindra school","Primary",200,"Mohindra");
        School s3=new School(3,"Deuty school","High",400,"Deuty");
        School s4=new School(4,"Taltola school","Primary",150,"Taltola");

        Configuration cfg= new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory= cfg.buildSessionFactory();
        Session session=sessionFactory.openSession();

        Transaction tx=session.beginTransaction();

        session.save(s1);
        session.saveOrUpdate(s2);
        session.save(s3);
        session.save(s4);
        tx.commit();

        Criteria criteria= (Criteria) session.createQuery(String.valueOf(School.class));




    }
}
