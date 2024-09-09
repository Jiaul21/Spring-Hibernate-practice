package org.example.HQL;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {

        School s1=new School(1,"Mahigonj school","High",500,"Mahigonj");
        School s2=new School(2,"Mohindra school","Primary",200,"Mohindra");
        School s3=new School(3,"Deuty school","High",400,"Deuty");
        School s4=new School(4,"Taltola school","Primary",150,"Taltola");

        Configuration cfg= new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory= cfg.buildSessionFactory();
        Session session=sessionFactory.openSession();


                ///    CREATE     ///

        Transaction tx=session.beginTransaction();

        session.save(s1);                               // save 1 record
        session.saveOrUpdate(s2);               // also save 1 record
        session.save(s3);
        session.save(s4);
        tx.commit();

        Query query;
        List<School> schools;

                ///     UPDATE      ///

//        tx=session.beginTransaction();
//        s3.setAddress("Deuty bazar");
//        session.saveOrUpdate(s3);                 // Update 1 record
//
//        query=session.createQuery("update School set address=:N where sId=:i");
//        query.setParameter("N","Mahigonj Bazar");
//        query.setParameter("i",1);
//        int updated= query.executeUpdate();
//        System.out.println(updated);
//        tx.commit();




                ///     DELETE      ///

//        tx=session.beginTransaction();
//        session.delete(s4);                     // Delete 1 record using object
//
//        query=session.createQuery("delete from School where address=:A ");
//        query.setParameter("A","Taltola");
//        int deleted= query.executeUpdate();      /// return total deleted number of record
//        tx.commit();



                ///     READ        ///

//        School s=(School) session.get(School.class,1);      // read 1 record
//        System.out.println(s);
//
//        query= session.createQuery("from School");    // read all record
//        schools=query.getResultList();
//        for(School sh:schools){
//            System.out.println(sh);
//        }
//
//            // query=session.createQuery("from School where type='High' and students>=200 ");
//        query=session.createQuery("from School where type=:T and students>=:N ");
//        query.setParameter("T","High");
//        query.setParameter("N",200);
//        schools=query.getResultList();
//        for(School sh:schools){
//            System.out.println(sh);
//        }


                        ///     Pagination      ///

//        query= session.createQuery("from School");    // Applying pagination from 0 index to next 2
//        query.setFirstResult(0);
//        query.setMaxResults(2);
//        schools=query.getResultList();
//        for(School sh:schools){
//            System.out.println(sh);
//        }


        session.close();
        sessionFactory.close();
    }
}
