package com.accounts.dao;

import com.accounts.model.Account;

import java.util.List;

/**
 * Data Access Object Interface - defines the standard set of operations to be performed on a model object
 */
public interface AccountDAO {

    Account findById(long id);

    void save(Account account);

    void update(Account account);

    void delete(Account account);

    List<Account> findAll();

}

