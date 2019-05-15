package com.accounts.utils;

import com.accounts.dao.AccountDAO;
import com.accounts.model.Account;

import static com.accounts.utils.LoadAppPropertyFile.getWebsite;
import static com.accounts.utils.LoadAppPropertyFile.getAction;
import static com.accounts.utils.LoadAppPropertyFile.getId;
import static com.accounts.utils.LoadAppPropertyFile.getLogin;
import static com.accounts.utils.LoadAppPropertyFile.getPassword;


public class AccountFactory {

    public void getAccount() {

        AccountDAO accountDAO = DbInitFactory.getDatabase(LoadAppPropertyFile.getDatabase());

        switch (Actions.valueOf(getAction())) {
            case DELETE:
                accountDAO.delete(new Account(Long.valueOf(getId())));
                break;
            case FINDALL:
                MakingEntriesToDbHelper.printAllFindings(accountDAO.findAll());
                break;
            case FINDBYID:
                MakingEntriesToDbHelper.printDataToConsole(accountDAO.findById(Integer.valueOf(getId())));
                break;
            case SAVE:
                accountDAO.save(new Account(getWebsite(), getLogin(), getPassword()));
                break;
            case UPDATE:
                accountDAO.update(new Account(Integer.valueOf(getId()), getWebsite(), getLogin(), getPassword()));
                break;
        }

    }

    public enum Actions {
        DELETE, FINDALL, FINDBYID, SAVE, UPDATE
    }
}
