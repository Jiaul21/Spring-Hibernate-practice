package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );

        Configuration cfg= new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory= cfg.buildSessionFactory();

        System.out.println(sessionFactory);

//        Teacher te= new Teacher();
//        te.setId(10);
//        te.setName("Fahim");
//        te.setAddress("Dhaka");

        Person per= new Person();
        per.setId(10);
        per.setName("jisan");
        per.setAddress("dhaka");
        per.setSalary(20000);
        per.setHight(5.3F);
        per.setIs_married(true);
        per.setDate(new Date());

        FileInputStream fileInputStream= new FileInputStream("src/main/java/org/example/linkedin.png");
        byte[] data= new byte[fileInputStream.available()];
        fileInputStream.read(data);
        per.setImage(data);

        Session session= sessionFactory.openSession();
        Transaction tx= session.beginTransaction();     // Transaction use to save data
        session.save(per);
        session.save(per);
        tx.commit();
        session.close();



    }
}
