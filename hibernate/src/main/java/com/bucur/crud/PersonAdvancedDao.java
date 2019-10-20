package com.bucur.crud;

import com.bucur.config.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PersonAdvancedDao {

    private static final Logger logger = Logger.getLogger(PersonAdvancedDao.class.getName());

    private Session session;
    private Transaction tx;

    /**
     * Insert a new Person into the database.
     *
     * @param person
     */
    public void create(Person person) {
        try {
            startOperation();
            session.save(person);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not save person");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * Find a Person by its primary key
     *
     * @param id
     * @return a person
     */
    public Person findById(Long id) {
        try {
            startOperation();
            return session.find(Person.class, id);
        } catch (HibernateException e) {
            logger.severe("could not find person with id " + id);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    /**
     * @return
     */
    public List findAll() {
        List<Person> people = new ArrayList<>();
        try {
            startOperation();
            Query query = session.createQuery("FROM Person");
            people = query.list();
        } catch (HibernateException e) {
            logger.severe("could not find all people");
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return people;
    }

    public void update(Person person) {
        try {
            startOperation();
            session.update(person);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not update person " + person);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void delete(Person person) {
        try {
            startOperation();
            session.delete(person);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not delete person " + person);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    private void startOperation() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
    }
}
