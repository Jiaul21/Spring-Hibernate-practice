package org.example.dbRelations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        First f1=new First(1,"1f value");
        First f2=new First(2,"2f value");
        First f3=new First(3,"3f value");

        Second s1=new Second(11,"1s value");
        Second s2=new Second(12,"2s value");
        Second s3=new Second(13,"3s value");

        List<Second> list=new ArrayList<Second>();
        list.add(s1);
        list.add(s2);
        list.add(s3);


        f1.second=list;

        s1.first=f1;
        s2.first=f2;
        s3.first=f3;


        Configuration cfg=new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory=cfg.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction tx=session.beginTransaction();
        session.save(f1);
        session.save(f2);
        session.save(f3);
        session.save(s1);
        session.save(s2);
        session.save(s3);
        tx.commit();


        First f;
        Second s;

        f=(First) session.get(First.class,1);
        System.out.println(f.fId+" "+f.fValue);
        s=(Second) session.get(Second.class,12);
        System.out.println(s.sId);


        session.close();
        sessionFactory.close();
    }
}
