package com.bucur.associations.one_to_many_bi;

import com.bucur.config.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ParentDao {

    private static final Logger logger = Logger.getLogger(ParentDao.class.getName());

    private Session session;
    private Transaction tx;

    /**
     * Insert a new Parent into the database.
     *
     * @param parent
     */
    public void create(Parent parent) {
        try {
            startOperation();
            session.save(parent);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not save parent");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * Find a Parent by its primary key
     *
     * @param id
     * @return a parent
     */
    public Parent findById(Long id) {
        try {
            startOperation();
            return session.find(Parent.class, id);
        } catch (HibernateException e) {
            logger.severe("could not find parent with id " + id);
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
        List<Parent> people = new ArrayList<>();
        try {
            startOperation();
            Query query = session.createQuery("FROM Parent");
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

    public void update(Parent parent) {
        try {
            startOperation();
            session.update(parent);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not update parent " + parent);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void delete(Parent parent) {
        try {
            startOperation();
            session.delete(parent);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not delete parent " + parent);
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
