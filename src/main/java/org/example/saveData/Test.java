package org.example.saveData;

import org.example.Job;
import org.example.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws IOException {

        System.out.println( "Hello World!" );

        Configuration cfg= new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory= cfg.buildSessionFactory();

        Person per= new Person();
        per.setId(10);
        per.setName("abir");
        per.setAddress("savar");
        per.setSalary(20000);
        per.setHight(5.3F);
        per.setIs_married(true);
        per.setDate(new Date());

        Job job=new Job();
        job.setJobName("Engineer");
        job.setLocation("Bonani");

        per.setJob(job);

        FileInputStream fileInputStream= new FileInputStream("src/main/java/org/example/linkedin.png");
        byte[] data= new byte[fileInputStream.available()];
        fileInputStream.read(data);

        per.setImage(data);

        Session session= sessionFactory.openSession();
        Transaction tx= session.beginTransaction();     // Transaction use to save data
        session.save(per);
        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
