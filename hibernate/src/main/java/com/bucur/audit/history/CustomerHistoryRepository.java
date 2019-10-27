package com.bucur.audit.history;

import com.bucur.config.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CustomerHistoryRepository {

    private static final Logger logger = Logger.getLogger(CustomerHistoryRepository.class.getName());

    private Session session;
    private Transaction tx;

    /**
     * Insert a new CustomerHistory into the database.
     *
     * @param customerHistory
     */
    public void create(CustomerHistory customerHistory) {
        try {
            startOperation();
            session.save(customerHistory);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not save customerHistory");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * Find a CustomerHistory by its primary key
     *
     * @param id
     * @return a customerHistory
     */
    public CustomerHistory findById(Long id) {
        try {
            startOperation();
            return session.find(CustomerHistory.class, id);
        } catch (HibernateException e) {
            logger.severe("could not find customerHistory with id " + id);
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
        List<CustomerHistory> people = new ArrayList<>();
        try {
            startOperation();
            Query query = session.createQuery("FROM CustomerHistory");
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

    public void update(CustomerHistory customerHistory) {
        try {
            startOperation();
            session.update(customerHistory);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not update customerHistory " + customerHistory);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void delete(CustomerHistory customerHistory) {
        try {
            startOperation();
            session.delete(customerHistory);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not delete customerHistory " + customerHistory);
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
