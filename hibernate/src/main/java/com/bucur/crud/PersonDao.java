package com.bucur.crud;

import com.bucur.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PersonDao {

    public void create(Person person) {
        Transaction transaction = null;
        try {
            // create session
            Session session = HibernateUtil.getSessionFactory().openSession();

            // begin transaction
            transaction = session.beginTransaction();

            // perform operation
            session.save(person);

            // commit
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Person findById(Long id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Person person = session.find(Person.class, id);
            return person;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(Person person) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(person);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void delete(Person person) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(person);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
