package com.bucur.associations.one_to_one_better;

import com.bucur.config.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class EmployeeDao {

    private static final Logger logger = Logger.getLogger(EmployeeDao.class.getName());

    private Session session;
    private Transaction tx;

    /**
     * Insert a new Employee into the database.
     *
     * @param employee
     */
    public void create(Employee employee) {
        try {
            startOperation();
            session.save(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not save employee");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * Find a Employee by its primary key
     *
     * @param id
     * @return a employee
     */
    public Employee findById(Long id) {
        try {
            startOperation();
            return session.find(Employee.class, id);
        } catch (HibernateException e) {
            logger.severe("could not find employee with id " + id);
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
        List<Employee> people = new ArrayList<>();
        try {
            startOperation();
            Query query = session.createQuery("FROM Employee");
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

    public void update(Employee employee) {
        try {
            startOperation();
            session.update(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not update employee " + employee);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void delete(Employee employee) {
        try {
            startOperation();
            session.delete(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not delete employee " + employee);
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
