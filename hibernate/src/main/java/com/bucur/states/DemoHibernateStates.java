package com.bucur.states;

import com.bucur.config.HibernateUtil;
import com.bucur.crud.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DemoHibernateStates {

    public static void main(String[] args) {
        // transient state
        Person person = new Person();
        person.setFirstName("jon");
        person.setLastName("snow");
        person.setEmail("jonsnow@gmail.com");
        person.setCountry("westeros");

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(person);

        tx.commit();
        // persistent

        session.close();
        // detached
    }
}
