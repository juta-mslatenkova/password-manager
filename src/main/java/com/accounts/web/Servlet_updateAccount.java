package com.accounts.web;

import com.accounts.model.Account;
import com.accounts.utils.AccountFactory;
import com.accounts.utils.ServletUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Servlet_updateAccount extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html");

        Long id = Long.valueOf(request.getParameter("accountId"));
        String website = request.getParameter("website");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        ServletUtil.setPropertiesFile(id, "UPDATE", website, login, password);

        // now calling the Model class responsible for business logics
        AccountFactory.doAction();

        PrintWriter out = response.getWriter();
        out.println("The data was updated");

        /*
         * Calling the findall method to display the updated database data
         */
        ServletUtil.setPropertiesFile(String.valueOf(id), "FINDALL");
        // now calling the Model class responsible for business logics
        AccountFactory.doAction();

        ServletUtil.displayAll(request, response);
    }


}