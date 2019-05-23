package com.accounts.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ServletUtil {

    public static void setPropertiesFile(String database, String id, String action) {
        Properties properties = new Properties();
        String propsFileName = "/Users/juta.miscenko/workspace/Password-Manager/src/main/resources/app.properties";
        try {

            FileInputStream configStream = new FileInputStream(propsFileName);
            properties.load(configStream);
            configStream.close();

            //modifies existing or adds new property
            properties.setProperty("action", action);
            properties.setProperty("database", database);
            properties.setProperty("id", id);

            //save modified property file
            File file = new File(propsFileName);
            FileOutputStream fileOut = new FileOutputStream(file);
            properties.store(fileOut, null);
            fileOut.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.print("Success");
    }

}
