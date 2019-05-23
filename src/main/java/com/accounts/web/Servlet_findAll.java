package com.accounts.web;

import com.accounts.dao.AccountDAO;
import com.accounts.dao.AccountDAOImpl_xml;
import com.accounts.model.Account;
import com.accounts.utils.AccountFactory;
import com.accounts.utils.ServletUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class Servlet_findAll extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html");

        String database = request.getParameter("database");
        String requestedId = "1";
        String action = "FINDALL";

        ServletUtil.setPropertiesFile(database, requestedId, action);

        System.out.println("database = " + database + " id= " + requestedId);

        // now calling the Model class responsible for business logics
        new AccountFactory().getAccount();

        ArrayList<Account> accountsList = Account.accountsList;
        request.setAttribute("data", accountsList);

        // defining our view jsp.page
        RequestDispatcher view = request.getRequestDispatcher("result.jsp");
        view.forward(request, response);
    }


}
