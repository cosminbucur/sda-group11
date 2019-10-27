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

public class PostDao {

    private static final Logger logger = Logger.getLogger(PostDao.class.getName());

    private Session session;
    private Transaction tx;

    /**
     * Insert a new Post into the database.
     *
     * @param post
     */
    public void create(Post post) {
        try {
            startOperation();
            session.save(post);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not save post");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * Find a Post by its primary key
     *
     * @param id
     * @return a post
     */
    public Post findById(Long id) {
        try {
            startOperation();
            return session.find(Post.class, id);
        } catch (HibernateException e) {
            logger.severe("could not find post with id " + id);
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
        List<Post> people = new ArrayList<>();
        try {
            startOperation();
            Query query = session.createQuery("FROM Post");
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

    public void update(Post post) {
        try {
            startOperation();
            session.update(post);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not update post " + post);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void delete(Post post) {
        try {
            startOperation();
            session.delete(post);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not delete post " + post);
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
