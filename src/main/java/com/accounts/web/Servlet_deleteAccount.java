package com.accounts.web;

import com.accounts.model.Account;
import com.accounts.utils.AccountFactory;
import com.accounts.utils.ServletUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class Servlet_deleteAccount extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html");

        String id = request.getParameter("accountId");

        ServletUtil.setPropertiesFile(id, "DELETE");

        // now calling the Model class responsible for business logics
        AccountFactory.doAction();

        /*
         * Calling the findall method to display the updated database data
         */

        ServletUtil.setPropertiesFile(id, "FINDALL");
        // now calling the Model class responsible for business logics
        AccountFactory.doAction();


        ArrayList<Account> accountsList = Account.accountsList;
        request.setAttribute("data", accountsList);

        // defining our view jsp.page
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
