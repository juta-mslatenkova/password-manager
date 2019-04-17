package com.accounts.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadAppProperties {

    private static String database;
    private static String action;
    private static String id;
    private static String website;
    private static String login;
    private static String password;

    public LoadAppProperties() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("app.properties")) {
            Properties properties = new Properties();

            // load a properties file
            properties.load(input);

            database = properties.getProperty("database");
            action = properties.getProperty("action");
            id = properties.getProperty("id");
            website = properties.getProperty("website");
            login = properties.getProperty("login");
            password = properties.getProperty("password");

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }


    public static String getDatabase() {
        return database;
    }

    public static String getAction() {
        return action;
    }

    public static String getId() {
        return id;
    }

    public static String getWebsite() {
        return website;
    }

    public static String getLogin() {
        return login;
    }

    public static String getPassword() {
        return password;
    }
}