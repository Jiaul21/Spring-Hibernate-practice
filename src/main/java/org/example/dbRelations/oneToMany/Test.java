package org.example.dbRelations.oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {

        Configuration cfg= new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory= cfg.buildSessionFactory();


        Answer2 a1=new Answer2();
        a1.setAnsId(1);
        a1.setAns("Dhaka is capital of BD");
        Answer2 a2=new Answer2();
        a2.setAnsId(2);
        a2.setAns("Bangladesh");
        Answer2 a3=new Answer2();
        a3.setAnsId(3);
        a3.setAns("currency is taka");

        List<Answer2> ansW=new ArrayList<Answer2>();
        ansW.add(a1);
        ansW.add(a2);
        ansW.add(a3);

        Question2 q1=new Question2();
        q1.setqId(10);
        q1.setQuestion("what about BD?");
        q1.setAnswer(ansW);



        Session session= sessionFactory.openSession();
        Transaction tx= session.beginTransaction();
//        session.save(a1);
//        session.save(a2);
//        session.save(a3);
        session.save(q1);
        tx.commit();

        Question2 q=session.get(Question2.class,10);
        System.out.println(q);

        Answer2 a=session.get(Answer2.class,2);
        System.out.println(a);

        session.close();
        sessionFactory.close();
    }
}
