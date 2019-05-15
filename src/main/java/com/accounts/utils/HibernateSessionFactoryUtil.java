package com.accounts.utils;

import com.accounts.model.Account;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * creates session factory to work with a database
 */
public class HibernateSessionFactoryUtil {

    private static SessionFactory factory;

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {

        if (factory == null) {
            try {
                // the class that should be considered as entity is passed to configuration
                factory = new Configuration().configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Account.class)
                        .buildSessionFactory();
            }

            catch (Exception e) {
                System.out.println("An error when building session factory");
                e.printStackTrace();
            }
        }
        return factory;
    }

}
