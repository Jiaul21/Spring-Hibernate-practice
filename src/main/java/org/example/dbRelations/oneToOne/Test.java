package org.example.dbRelations.oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {

        Configuration cfg= new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory= cfg.buildSessionFactory();


        Answer a1=new Answer();
        a1.setAnsId(1);
        a1.setAns("Dhaka is capital of BD");
        Answer a2=new Answer();
        a2.setAnsId(2);
        a2.setAns("Bangladesh");
        Answer a3=new Answer();
        a3.setAnsId(3);
        a3.setAns("taka");

        Question q1=new Question();
        q1.setqId(10);
        q1.setQuestion("what is capital of BD?");
        q1.setAnswer(a1);
        Question q2=new Question();
        q2.setqId(11);
        q2.setQuestion("country name?");
        q2.setAnswer(a2);
        Question q3=new Question();
        q3.setqId(12);
        q3.setQuestion("currency name?");
        q3.setAnswer(a3);


        Session session= sessionFactory.openSession();
        Transaction tx= session.beginTransaction();
        session.save(q1);
        session.save(q2);
        session.save(q3);
        session.save(a1);
        session.save(a2);
        session.save(a3);
        tx.commit();

        Question q=session.get(Question.class,10);
        System.out.println(q);

        Answer a=session.get(Answer.class,2);
        System.out.println(a);

        session.close();
        sessionFactory.close();
    }
}
