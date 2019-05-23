package com.accounts.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet_addAccount extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        System.out.println("I was here!!!!!!!!!!!!");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Thanks ");
//        String age = request.getParameter("age");
//        out.println(age);

        // now calling the Model class responsible for business logics
        //        Model_FlowerExpert model_flowerExpert = new Model_FlowerExpert();


        // request.setAttribute("flowers", result);

        // defining our view jsp.page
//        RequestDispatcher view = request.getRequestDispatcher("add-account.jsp");
//        view.forward(request, response);
    }
}
