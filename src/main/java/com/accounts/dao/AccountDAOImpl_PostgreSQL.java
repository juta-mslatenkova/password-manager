package com.accounts.dao;

import com.accounts.model.Account;
import com.accounts.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;

import java.util.List;

import org.hibernate.Transaction;

/**
 * Data Access Model Concrete class - responsible for getting data from a datasource
 */
public class AccountDAOImpl implements AccountDAO {

    @Override
    public Account findById(int id) {
        Account account = HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Account.class, id);
        System.out.println("Found by id=" + account.getId() + ": " + account.getWebsite() + " " + account.getWebsite() + " " + account.getPassword());
        return account;
    }

    @Override
    public void save(Account account) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(account);
        transaction.commit();
        session.close();
    }


    @Override
    public void update(Account account) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(account);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Account account) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(account);
        transaction.commit();
        session.close();

    }

    @Override
    public List<Account> findAll() {
        List<Account> accounts = (List<Account>) HibernateSessionFactoryUtil.getSessionFactory().openSession()
                .createQuery("FROM Account").list();

        System.out.println(accounts.get(3).getWebsite());
        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            System.out.println(account.getId() + ": " + account.getWebsite() + " " + account.getWebsite() + " " + account.getPassword());


        }
        return accounts;
    }
}
