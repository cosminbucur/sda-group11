package com.bucur.associations.one_to_mani_uni;

import com.bucur.config.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MotherDao {

    private static final Logger logger = Logger.getLogger(MotherDao.class.getName());

    private Session session;
    private Transaction tx;

    /**
     * Insert a new Mother into the database.
     *
     * @param mother
     */
    public void create(Mother mother) {
        try {
            startOperation();
            session.save(mother);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not save mother");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * Find a Mother by its primary key
     *
     * @param id
     * @return a mother
     */
    public Mother findById(Long id) {
        try {
            startOperation();
            return session.find(Mother.class, id);
        } catch (HibernateException e) {
            logger.severe("could not find mother with id " + id);
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
        List<Mother> people = new ArrayList<>();
        try {
            startOperation();
            Query query = session.createQuery("FROM Mother");
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

    public void update(Mother mother) {
        try {
            startOperation();
            session.update(mother);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not update mother " + mother);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void delete(Mother mother) {
        try {
            startOperation();
            session.delete(mother);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not delete mother " + mother);
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
