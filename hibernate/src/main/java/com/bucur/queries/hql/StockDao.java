package com.bucur.queries.hql;

import com.bucur.config.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class StockDao {

    private static final Logger logger = Logger.getLogger(StockDao.class.getName());

    private Session session;
    private Transaction tx;

    /**
     * Insert a new Stock into the database.
     *
     * @param stock
     */
    public void create(Stock stock) {
        try {
            startOperation();
            session.save(stock);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not save stock");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * Find a Stock by its primary key
     *
     * @param id
     * @return a stock
     */
    public Stock findById(Long id) {
        try {
            startOperation();
            return session.find(Stock.class, id);
        } catch (HibernateException e) {
            logger.severe("could not find stock with id " + id);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    public List findAllWithHqlQuery() {
//        String hql = "from com.bucur.queries.hql.Stock";
        String hql = "from Stock";

        List result = new ArrayList();
        try {
            startOperation();

            // query using HQL
            Query query = session.createQuery(hql, Stock.class);
            result = query.getResultList();
            session.close();
        } catch (Exception e) {
            logger.severe("error executing hql: " + hql);
        }
        return result;
    }

    public List findAllByStockCodeNamedQuery(String stockCode) {
        String hqlQueryName = "findStocksByStockCode";

        List result = new ArrayList();
        try {
            startOperation();

            // named query with parameters using HQL
            // use query from javax.persistence.query
            Query namedQuery = session.createNamedQuery(hqlQueryName, Stock.class);
            namedQuery.setParameter("stockCode", stockCode);
            result = namedQuery.getResultList();

            session.close();
        } catch (Exception e) {
            logger.severe("error executing sql: " + hqlQueryName);
        }
        return result;
    }

    /**
     * @return
     */
    public List findAll() {
        List<Stock> people = new ArrayList<>();
        try {
            startOperation();
            Query query = session.createQuery("FROM Stock");
            people = query.getResultList();
        } catch (HibernateException e) {
            logger.severe("could not find all people");
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return people;
    }

    public void update(Stock stock) {
        try {
            startOperation();
            session.update(stock);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not update stock " + stock);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void delete(Stock stock) {
        try {
            startOperation();
            session.delete(stock);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not delete stock " + stock);
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
