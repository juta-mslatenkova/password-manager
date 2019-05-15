package com.accounts.dao;

import com.accounts.model.Account;
import com.accounts.utils.JDBCHelper;
import com.accounts.utils.MakingEntriesToDbHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.accounts.utils.JDBCHelper.getConnection;
import static com.google.common.base.Preconditions.checkArgument;

public class AccountDAOImpl_PostgreSQL_JDBC implements AccountDAO {

    private String sql; // the sql request to be executed

    // initialising database first
    static {
        try {
            JDBCHelper.init();
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    // getting Statement (interface used for connecting to the database)
    private Statement getStatement() throws SQLException{
            return getConnection().createStatement();
    }


    @Override
    public Account findById(int id) {
        sql = "SELECT userId, website, login, passwords FROM accounts WHERE userId = " + "'" + id + "'";
        return getDataFromResultSet(getResultSetFromDb(sql));
    }

    @Override
    public void save(Account account) {
        checkArgument(MakingEntriesToDbHelper.isLoginAndPassComboUnique(account, findAll()),
                "Oooops, data was not added as the website and login combination is not unique");

        sql = "INSERT INTO accounts (login, website, passwords) VALUES (" +
                "'" + account.getLogin() + "'," +
                "'" + account.getWebsite() + "'," +
                "'" + account.getPassword() + "')";
        getResultSetFromDb(sql);
    }

    @Override
    public void update(Account account) {
        checkArgument(MakingEntriesToDbHelper.isLoginAndPassComboUnique(account, findAll()),
                "Oooops, data was not added as the website and login combination is not unique");

        sql = "UPDATE accounts SET login = " + "'" + account.getLogin() + "'," +
                "website = " + "'" + account.getWebsite() + "'," +
                "passwords = " + "'" + account.getPassword() + "'" +
                "WHERE userId = " + "'" + account.getId() + "'";
        getResultSetFromDb(sql);
    }

    @Override
    public void delete(Account account) {
        sql = "DELETE FROM accounts WHERE userId= " + "'" + account.getId() + "'";
        getResultSetFromDb(sql);
    }

    @Override
    public List<Account> findAll() {
        sql = "SELECT userId, website, login, passwords FROM accounts";
        ResultSet resultSet = getResultSetFromDb(sql);

        List<Account> accountList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                accountList.add(new Account(resultSet.getString("website"),
                        resultSet.getString("login"),
                        resultSet.getString("passwords")));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return accountList;
    }

    // method returns set of data obtained from the database
    private ResultSet getResultSetFromDb(String sql) {
        try {
            // resultSet = statement.executeQuery(sql);
            return getStatement().executeQuery(sql);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    private static Account getDataFromResultSet(ResultSet resultSet)  {
        try {
            while (resultSet.next()) {

                String website = resultSet.getString("website");
                String login = resultSet.getString("login");
                String password = resultSet.getString("passwords");

                return new Account(website, login, password);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

}
