package com.app.data;

public class Main {

    public static WebsiteDataManager websiteDataManager;   // instantiate class that holds the logics of every action e.g. delete, update, etc.

    // the values you can set for the db entries
    private static int id = 1;
    private static String website = "www.firstSite.com";
    private static String login = "login_one7gsв";
    private static String password = "n2222g";

    public static void main(String[] args) {

        // open the database helper class and parse the xml file with data
        DatabaseHelper.parseXML();
        websiteDataManager = new WebsiteDataManager();

        /**
         *  Uncomment the method you need to communicate with xml database
         */
        // websiteDataManager.printDbEntryById(id);
        // websiteDataManager.deleteDbEntryById(id);
        // websiteDataManager.updateDbEntryById(id, website, login, password);
        // websiteDataManager.createDbEntry(setDataForTheNewEntry(website, login, password));
        createDbEntry(website, login, password);
        websiteDataManager.printAllDbEntries();
    }

    /**
     * methods checks whether the data set is unique and makes a new entry to a database
     */
    private static void createDbEntry(String website, String login, String password){
        // check if the login and website combination is unique
        if (DbEntriesManagement.areSiteAndPasswordComboUnique(website, login)){
            // create a list of data to be entered in the db
            DbEntriesManagement.setDataForTheNewEntry(website, login, password);
        }
        else{
            throw new IllegalStateException("Oooops, data was not added as the website and login combination are not unique");
        }
        // create the entry
        websiteDataManager.createDbEntry(DbEntriesManagement.getDbEntryList());


    }

}
