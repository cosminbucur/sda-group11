package com.bucur.queries.native_sql;

import com.bucur.config.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class TraderDao {

    private static final Logger logger = Logger.getLogger(TraderDao.class.getName());

    private Session session;
    private Transaction tx;

    /**
     * Insert a new Trader into the database.
     *
     * @param trader
     */
    public void create(Trader trader) {
        try {
            startOperation();
            session.save(trader);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not save trader");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * Find a Trader by its primary key
     *
     * @param id
     * @return a trader
     */
    public Trader findById(Long id) {
        try {
            startOperation();
            return session.find(Trader.class, id);
        } catch (HibernateException e) {
            logger.severe("could not find trader with id " + id);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    public List findAllWithNativeQuery() {
        String sql = "SELECT * FROM trader";

        List result = new ArrayList();
        try {
            startOperation();
            NativeQuery nativeQuery = session.createNativeQuery(sql, Trader.class);
            result = nativeQuery.list();
            session.close();
        } catch (Exception e) {
            logger.severe("error executing sql: " + sql);
        }
        return result;
    }

    public List findAllByNameNamedNativeQuery(String name) {
        String nativeQueryName = "findTradersByNameNativeSQL";

        List result = new ArrayList();
        try {
            startOperation();

            // use query from org.hibernate.query
            Query<Trader> namedNativeQuery = session.createNamedQuery(nativeQueryName, Trader.class);
            namedNativeQuery.setParameter("name", name);

            result = namedNativeQuery.list();
            session.close();
        } catch (Exception e) {
            logger.severe("error executing sql: " + nativeQueryName);
        }
        return result;
    }

    /**
     * @return
     */
    public List findAll() {
        List<Trader> people = new ArrayList<>();
        try {
            startOperation();
            Query query = session.createQuery("FROM Trader");
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

    public void update(Trader trader) {
        try {
            startOperation();
            session.update(trader);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not update trader " + trader);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void delete(Trader trader) {
        try {
            startOperation();
            session.delete(trader);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not delete trader " + trader);
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
