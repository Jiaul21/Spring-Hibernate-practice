package org.example.fetchData;

import org.example.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        System.out.println("Fetching Data from DataBase");

        Configuration cfg= new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory= cfg.buildSessionFactory();

        Session session= sessionFactory.openSession();

        Person person1= (Person) session.get(Person.class,1);
        System.out.println(person1);

        session.close();
        Person person2=(Person) session.load(Person.class,1);
        System.out.println(person2);
        sessionFactory.close();

    }
}
