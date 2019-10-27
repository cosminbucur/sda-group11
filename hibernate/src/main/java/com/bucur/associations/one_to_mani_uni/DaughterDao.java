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

public class DaughterDao {

    private static final Logger logger = Logger.getLogger(DaughterDao.class.getName());

    private Session session;
    private Transaction tx;

    /**
     * Insert a new Daughter into the database.
     *
     * @param daughter
     */
    public void create(Daughter daughter) {
        try {
            startOperation();
            session.save(daughter);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not save daughter");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * Find a Daughter by its primary key
     *
     * @param id
     * @return a daughter
     */
    public Daughter findById(Long id) {
        try {
            startOperation();
            return session.find(Daughter.class, id);
        } catch (HibernateException e) {
            logger.severe("could not find daughter with id " + id);
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
        List<Daughter> people = new ArrayList<>();
        try {
            startOperation();
            Query query = session.createQuery("FROM Daughter");
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

    public void update(Daughter daughter) {
        try {
            startOperation();
            session.update(daughter);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not update daughter " + daughter);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void delete(Daughter daughter) {
        try {
            startOperation();
            session.delete(daughter);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not delete daughter " + daughter);
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
