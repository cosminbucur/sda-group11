package com.bucur.associations.one_to_mani_uni_join;

import com.bucur.config.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SonDao {

    private static final Logger logger = Logger.getLogger(SonDao.class.getName());

    private Session session;
    private Transaction tx;

    /**
     * Insert a new Son into the database.
     *
     * @param son
     */
    public void create(Son son) {
        try {
            startOperation();
            session.save(son);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not save son");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * Find a Son by its primary key
     *
     * @param id
     * @return a son
     */
    public Son findById(Long id) {
        try {
            startOperation();
            return session.find(Son.class, id);
        } catch (HibernateException e) {
            logger.severe("could not find son with id " + id);
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
        List<Son> people = new ArrayList<>();
        try {
            startOperation();
            Query query = session.createQuery("FROM Son");
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

    public void update(Son son) {
        try {
            startOperation();
            session.update(son);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not update son " + son);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void delete(Son son) {
        try {
            startOperation();
            session.delete(son);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not delete son " + son);
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
