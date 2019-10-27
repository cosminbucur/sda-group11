package com.bucur.config;

import com.bucur.associations.many_to_many.Post;
import com.bucur.associations.many_to_many.Tag;
import com.bucur.associations.one_to_mani_uni.Daughter;
import com.bucur.associations.one_to_mani_uni.Mother;
import com.bucur.associations.one_to_mani_uni_join.Father;
import com.bucur.associations.one_to_mani_uni_join.Son;
import com.bucur.associations.one_to_many_bi.Child;
import com.bucur.associations.one_to_many_bi.Parent;
import com.bucur.associations.one_to_one.Account;
import com.bucur.associations.one_to_one.Employee;
import com.bucur.audit.customer.Customer;
import com.bucur.audit.history.CustomerHistory;
import com.bucur.crud.Person;
import com.bucur.queries.hql.Stock;
import com.bucur.queries.native_sql.Trader;
import com.bucur.types.Player;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {

    private static SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private static SessionFactory buildSessionFactory() {
        // load up the configuration
        Configuration configuration = createConfig();

        // build the registry using the properties in the configuration
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();

        // build the session factory from the service registry
        return configuration.buildSessionFactory(serviceRegistry);
    }

    private static Configuration createConfig() {
        Configuration configuration = new Configuration();

        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate?serverTimezone=UTC");
        settings.put(Environment.USER, "root");
        settings.put(Environment.PASS, "root");
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        settings.put(Environment.SHOW_SQL, "true");
        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        settings.put(Environment.HBM2DDL_AUTO, "create-drop");
        configuration.setProperties(settings);

        // add annotated classes
        configuration.addAnnotatedClass(Person.class);

        configuration.addAnnotatedClass(Player.class);

        configuration.addAnnotatedClass(Employee.class);
        configuration.addAnnotatedClass(Account.class);

        configuration.addAnnotatedClass(Mother.class);
        configuration.addAnnotatedClass(Daughter.class);

        configuration.addAnnotatedClass(Father.class);
        configuration.addAnnotatedClass(Son.class);

        configuration.addAnnotatedClass(Parent.class);
        configuration.addAnnotatedClass(Child.class);

        configuration.addAnnotatedClass(Post.class);
        configuration.addAnnotatedClass(Tag.class);

        configuration.addAnnotatedClass(Trader.class);
        configuration.addAnnotatedClass(Stock.class);

        configuration.addAnnotatedClass(Customer.class);
        configuration.addAnnotatedClass(CustomerHistory.class);

        return configuration;
    }

}
