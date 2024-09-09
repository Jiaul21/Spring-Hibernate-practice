package org.example.dbRelations.manyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        Configuration cfg= new Configuration();
        cfg.configure("hibernate.cfg.xml");

        Atm a1=new Atm();
        Atm a2=new Atm();
        Users u1=new Users();
        Users u2=new Users();

        a1.setAtmId(11);
        a1.setLocation("dhanmondi");
        a2.setAtmId(12);
        a2.setLocation("uttara");

        u1.setUserId(21);
        u1.setName("abir");
        u2.setUserId(22);
        u2.setName("jisan");

        List<Atm> aList=new ArrayList<Atm>();
        List<Users> uList=new ArrayList<Users>();

        aList.add(a1);
        aList.add(a2);
        uList.add(u1);
        uList.add(u2);

        a1.setUsers(uList);
        u2.setAtms(aList);

        SessionFactory sessionFactory=cfg.buildSessionFactory();
        Session session= sessionFactory.openSession();
        Transaction tx=session.beginTransaction();

        session.save(a1);
        session.save(a2);
        session.save(u1);
        session.save(u2);

        tx.commit();

        Atm a=(Atm) session.get(Atm.class,11);
        for(Users i:a.getUsers()){
            System.out.println(i.getUserId()+" "+i.getName());
        }
        Users u=(Users) session.get(Users.class,22);
        for(Atm i:u.getAtms()){
            System.out.println(i.getAtmId()+" "+i.getLocation());
        }

//        Users u=(Users) session.get(Users.class,22);      // full object can not be printed, stack overflow occurs
//        System.out.println(u);

        session.close();
        sessionFactory.close();
    }
}
