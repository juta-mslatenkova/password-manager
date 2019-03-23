package com.app.data;

import java.util.List;

/**
 * interface describing the actions that can be used for password-database management
 */
public interface WebsiteDataManagerInterface {

    void createDbEntry(List<String> valuesList);

    void printDbEntryById(int id);

    void printAllDbEntries();

    void updateDbEntryById(int id, String newWebsite, String newLogin, String newPassword);

    void deleteDbEntryById(int id);
}
