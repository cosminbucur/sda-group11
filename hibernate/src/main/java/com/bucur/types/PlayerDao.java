package com.bucur.types;

import com.bucur.config.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PlayerDao {

    private static final Logger logger = Logger.getLogger(PlayerDao.class.getName());

    private Session session;
    private Transaction tx;

    /**
     * Insert a new Player into the database.
     *
     * @param player
     */
    public void create(Player player) {
        try {
            startOperation();
            session.save(player);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not save player");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * Find a Player by its primary key
     *
     * @param id
     * @return a player
     */
    public Player findById(Long id) {
        try {
            startOperation();
            return session.find(Player.class, id);
        } catch (HibernateException e) {
            logger.severe("could not find player with id " + id);
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
        List<Player> people = new ArrayList<>();
        try {
            startOperation();
            Query query = session.createQuery("FROM Player");
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

    public void update(Player player) {
        try {
            startOperation();
            session.update(player);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not update player " + player);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void delete(Player player) {
        try {
            startOperation();
            session.delete(player);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not delete player " + player);
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
