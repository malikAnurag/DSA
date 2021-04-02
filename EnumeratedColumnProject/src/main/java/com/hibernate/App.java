package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 * This project creates an entity and checks the use of @Enumerated annotation in hibernate.
 */

public class App 
{
    public static void main( String[] args )
    {

        // Use this with 4.3.5 version

//        AnnotationConfiguration cfg = new AnnotationConfiguration();
//        Session session = cfg.configure("hibernate.cfg.xml").buildSessionFactory().openSession();
//..................................................................
        //Use these with 5.0.11 version
        Configuration cf = new Configuration();
        cf.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = cf.buildSessionFactory();
        Session session = sessionFactory.openSession();

//.....................................................................

        Transaction t = session.beginTransaction();

        Person malePerson = new Person("Tom", Gender.MALE.toString());
        session.save(malePerson);

        Person femalePerson = new Person("Mary", Gender.FEMALE.toString());
        session.save(femalePerson);

        System.out.println("Commit successful!!!");

        session.getTransaction().commit();
        session.close();

//        session.persist(malePerson);
//        session.persist(femalePerson);

        System.out.println("Your session has been closed,");
    }
}
