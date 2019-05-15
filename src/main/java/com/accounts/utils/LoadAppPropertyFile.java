package com.accounts.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadAppPropertyFile {

    private static Properties properties;

    static {
        properties = new Properties();
        try (InputStream input = LoadAppPropertyFile.class.getClassLoader().getResourceAsStream("app.properties")) {
            // load a properties file
            properties.load(input);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private LoadAppPropertyFile() {
    }

    public static String getDatabase() {
        return properties.getProperty("database");
    }

    public static String getAction() {
        return properties.getProperty("action");
    }

    public static String getId() {
        return properties.getProperty("id");
    }

    public static String getWebsite() {
        return properties.getProperty("website");
    }

    public static String getLogin() {
        return properties.getProperty("login");
    }

    public static String getPassword() {
        return properties.getProperty("password");
    }
}