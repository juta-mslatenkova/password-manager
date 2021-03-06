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
import java.util.ArrayList;

import static com.accounts.utils.ServletUtil.displayAll;

public class Servlet_findAll extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html");

        String database = request.getParameter("database");
        String requestedId = "1";

        ServletUtil.setPropertiesFile(database, requestedId, "FINDALL");

        System.out.println("database = " + database + " id= " + requestedId);

        // now calling the Model class responsible for business logics
        AccountFactory.doAction();

        displayAll(request, response);
    }


}
