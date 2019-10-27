package com.bucur.associations.many_to_many;

import com.bucur.config.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class TagDao {

    private static final Logger logger = Logger.getLogger(TagDao.class.getName());

    private Session session;
    private Transaction tx;

    /**
     * Insert a new Tag into the database.
     *
     * @param tag
     */
    public void create(Tag tag) {
        try {
            startOperation();
            session.save(tag);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not save tag");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * Find a Tag by its primary key
     *
     * @param id
     * @return a tag
     */
    public Tag findById(Long id) {
        try {
            startOperation();
            return session.find(Tag.class, id);
        } catch (HibernateException e) {
            logger.severe("could not find tag with id " + id);
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
        List<Tag> people = new ArrayList<>();
        try {
            startOperation();
            Query query = session.createQuery("FROM Tag");
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

    public void update(Tag tag) {
        try {
            startOperation();
            session.update(tag);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not update tag " + tag);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void delete(Tag tag) {
        try {
            startOperation();
            session.delete(tag);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not delete tag " + tag);
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
