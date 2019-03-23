package com.app.data;

import java.util.ArrayList;
import java.util.List;

public class DbEntriesManagement {


    private static List<String> dbEntryList;

    // private constructor protects class from being instantiated in other classes
    private DbEntriesManagement() {
    }

    /**
     * method checks if the login and website combination is unique
     */
    public static boolean areSiteAndPasswordComboUnique(String website, String login) {

        for (int id = 0; id < Main.websiteDataManager.getNodeList().getLength(); id++) {
            String webSiteFromDb = DatabaseHelper.document.getElementsByTagName("website").item(id).getTextContent();
            if (webSiteFromDb.equals(website)) {
                String loginFromDb = DatabaseHelper.document.getElementsByTagName("login").item(id).getTextContent();
                if (loginFromDb.equals(login)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * method creates a list of data to be set to the database
     *
     * @param website
     * @param login
     * @param password
     * @return
     */
    public static List<String> setDataForTheNewEntry(String website, String login, String password) {
        dbEntryList = new ArrayList<>();
        dbEntryList.add(generateUniqueId());
        dbEntryList.add(website);
        dbEntryList.add(login);
        dbEntryList.add(password);

        return dbEntryList;
    }

    public static String generateUniqueId() {
        // unique id gonna be generated basing on the very specific time the record was made in
        return String.valueOf(System.currentTimeMillis());
    }

    public static List<String> getDbEntryList() {
        return dbEntryList;
    }

    private void setDbEntryList(List<String> stringList) {
        this.dbEntryList = stringList;
    }

}
