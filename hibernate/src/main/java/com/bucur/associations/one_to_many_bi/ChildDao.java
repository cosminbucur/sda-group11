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

public class ChildDao {

    private static final Logger logger = Logger.getLogger(ChildDao.class.getName());

    private Session session;
    private Transaction tx;

    /**
     * Insert a new Child into the database.
     *
     * @param child
     */
    public void create(Child child) {
        try {
            startOperation();
            session.save(child);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not save child");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * Find a Child by its primary key
     *
     * @param id
     * @return a child
     */
    public Child findById(Long id) {
        try {
            startOperation();
            return session.find(Child.class, id);
        } catch (HibernateException e) {
            logger.severe("could not find child with id " + id);
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
        List<Child> people = new ArrayList<>();
        try {
            startOperation();
            Query query = session.createQuery("FROM Child");
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

    public void update(Child child) {
        try {
            startOperation();
            session.update(child);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not update child " + child);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void delete(Child child) {
        try {
            startOperation();
            session.delete(child);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not delete child " + child);
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
