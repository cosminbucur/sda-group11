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

public class FatherDao {

    private static final Logger logger = Logger.getLogger(FatherDao.class.getName());

    private Session session;
    private Transaction tx;

    /**
     * Insert a new Father into the database.
     *
     * @param father
     */
    public void create(Father father) {
        try {
            startOperation();
            session.save(father);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not save father");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * Find a Father by its primary key
     *
     * @param id
     * @return a father
     */
    public Father findById(Long id) {
        try {
            startOperation();
            return session.find(Father.class, id);
        } catch (HibernateException e) {
            logger.severe("could not find father with id " + id);
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
        List<Father> people = new ArrayList<>();
        try {
            startOperation();
            Query query = session.createQuery("FROM Father");
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

    public void update(Father father) {
        try {
            startOperation();
            session.update(father);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not update father " + father);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void delete(Father father) {
        try {
            startOperation();
            session.delete(father);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not delete father " + father);
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
