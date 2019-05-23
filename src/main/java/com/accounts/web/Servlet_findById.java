package com.accounts.web;

import com.accounts.model.Account;
import com.accounts.utils.AccountFactory;
import com.accounts.utils.ServletUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;

public class Servlet_findById extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html");

        String database = request.getParameter("database");
        String requestedId = request.getParameter("id");
        String action = "FINDBYID";

        ServletUtil.setPropertiesFile(database, requestedId, action);

        System.out.println("database = " + database + " id= " + requestedId);

        // now calling the Model class responsible for business logics
        new AccountFactory().getAccount();

        long id = Account.account.getId();
        String website = Account.account.getWebsite();
        String login = Account.account.getLogin();
        String password = Account.account.getPassword();

        ArrayList<Account> accountsList = new ArrayList<>();
        accountsList.add(new Account(id, website, login, password));
        request.setAttribute("data", accountsList);

        // defining our view jsp.page
        RequestDispatcher view = request.getRequestDispatcher("result.jsp");
        view.forward(request, response);
    }
}