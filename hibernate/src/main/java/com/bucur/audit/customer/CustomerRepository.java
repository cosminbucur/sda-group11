package com.bucur.audit.customer;

import com.bucur.config.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CustomerRepository {

    private static final Logger logger = Logger.getLogger(CustomerRepository.class.getName());

    private Session session;
    private Transaction tx;

    /**
     * Insert a new Customer into the database.
     *
     * @param customer
     */
    public void create(Customer customer) {
        try {
            startOperation();
            session.save(customer);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not save customer");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * Find a Customer by its primary key
     *
     * @param id
     * @return a customer
     */
    public Customer findById(Long id) {
        try {
            startOperation();
            return session.find(Customer.class, id);
        } catch (HibernateException e) {
            logger.severe("could not find customer with id " + id);
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
        List<Customer> people = new ArrayList<>();
        try {
            startOperation();
            Query query = session.createQuery("FROM Customer");
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

    public void update(Customer customer) {
        try {
            startOperation();
            session.update(customer);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not update customer " + customer);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void delete(Customer customer) {
        try {
            startOperation();
            session.delete(customer);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not delete customer " + customer);
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
