package com.accounts.utils;

import com.accounts.model.Account;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class ServletUtil {

    private static Properties properties = new Properties();
    private static String propsFileName = "app.properties";

    public static void setPropertiesFile(String database, String id, String action) {
        openPropertiesFile();

        //modifies existing or adds new property
        properties.setProperty("action", action);
        properties.setProperty("database", database);
        properties.setProperty("id", id);

        savePropertiesFile();
    }

    public static void setPropertiesFile(String id, String action) {
        openPropertiesFile();

        //modifies existing or adds new property
        properties.setProperty("action", action);
        properties.setProperty("id", id);

        savePropertiesFile();
    }

    public static void setPropertiesFile(String database, String action, String website, String login, String password) {
        openPropertiesFile();

        //modifies existing or adds new property
        properties.setProperty("action", action);
        properties.setProperty("database", database);
        properties.setProperty("password", password);
        properties.setProperty("website", website);
        properties.setProperty("login", login);

        savePropertiesFile();
    }

    public static void setPropertiesFile(Long id, String action, String website, String login, String password) {
        openPropertiesFile();

        //modifies existing or adds new property
        properties.setProperty("action", action);
        properties.setProperty("id", String.valueOf(id));
        properties.setProperty("password", password);
        properties.setProperty("website", website);
        properties.setProperty("login", login);

        savePropertiesFile();
    }

    private static void openPropertiesFile() {
        try {
            FileInputStream configStream = new FileInputStream(propsFileName);
            properties.load(configStream);
            configStream.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void savePropertiesFile() {
        try {
            File file = new File(propsFileName);
            FileOutputStream fileOut = new FileOutputStream(file);
            properties.store(fileOut, null);
            fileOut.close();
            LoadAppPropertyFile.reloadProperties();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void displayAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Account> accountsList = Account.accountsList;
        request.setAttribute("data", accountsList);

        // defining our view jsp.page
        RequestDispatcher view = request.getRequestDispatcher("result.jsp");
        view.forward(request, response);
    }

}

