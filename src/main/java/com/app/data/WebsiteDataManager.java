package com.app.data;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

import static com.app.data.DatabaseHelper.*;

/**
 * class that keeps all the logics of the actions that the xml.database can be asked to perform
 */

public class WebsiteDataManager implements WebsiteDataManagerInterface {

    private static final String LOG_PASS = "log-pass";
    NodeList nodeList = document.getElementsByTagName(LOG_PASS);

    /**
     * methods creates new database entry
     * @param valuesList
     */
    @Override
    public void createDbEntry(List<String> valuesList) {

        // create new "log-pass" element" in the root node "logins-passwords"
        Element newDbEntry = document.createElement(LOG_PASS);
        root.appendChild(newDbEntry);

        // create array of subNodes tags
        String[] subNodes = {"id", "website", "login", "password"};

        // create list of sub-nodes: id, website, login, password
        List<Element> elementList = new ArrayList<>();
        for (String subNode : subNodes) {
            elementList.add(document.createElement(subNode));
        }

        int i = 0; // used to iterate through the valueList (data for the db entry)
        for (Element element : elementList) {
            // set the values for the sub-nodes
            element.appendChild(document.createTextNode(valuesList.get(i)));
            i++;
            newDbEntry.appendChild(element);
        }

        saveDataToXML();

    }

    /**
     * methods prints out the info about the specific entry requested by id
     * @param itemId
     */
    @Override
    public void printDbEntryById(int itemId) {
        itemId--; // because indexing starts with 0
        printTextContentsOfXMLNode(itemId);
    }

    /**
     * method prints out all the entries the database has
     */
    @Override
    public void printAllDbEntries() {
        for (int itemId = 0; itemId < nodeList.getLength(); itemId++) {
            printTextContentsOfXMLNode(itemId);
        }
    }

    /**
     * methods changes the values of database entries for the specific id
     * @param itemId
     * @param newWebsite
     * @param newLogin
     * @param newPassword
     */
    @Override
    public void updateDbEntryById(int itemId, String newWebsite, String newLogin, String newPassword) {
        itemId--; // because indexing starts with 0

        if (DbEntriesManagement.areSiteAndPasswordComboUnique(newWebsite, newLogin)) {

            // set new content to the database entry
            document.getElementsByTagName("website").item(itemId).setTextContent(newWebsite);
            document.getElementsByTagName("login").item(itemId).setTextContent(newLogin);
            document.getElementsByTagName("password").item(itemId).setTextContent(newPassword);

            System.out.println("Updated data for the id = " + itemId);

            saveDataToXML();
        }
        else {
            throw new IllegalStateException("Oooops, data was not added as the website and login combination are not unique");
        }
    }

    /**
     * methods deletes database entry for the requested id
     * @param itemId
     */
    @Override
    public void deleteDbEntryById(int itemId) {
        itemId--; // because indexing starts with 0
        Node nodeToDelete = root.getElementsByTagName(LOG_PASS).item(itemId);
        root.removeChild(nodeToDelete);

        System.out.println("Deleted data for the id = " + itemId);
    }

    /**
     * method writes down text content of the database elements
     * @param itemId -
     */
    private void printTextContentsOfXMLNode(int itemId) {
        System.out.println(document.getElementsByTagName("id").item(itemId).getTextContent());
        System.out.println(document.getElementsByTagName("website").item(itemId).getTextContent());
        System.out.println(document.getElementsByTagName("login").item(itemId).getTextContent());
        System.out.println(document.getElementsByTagName("password").item(itemId).getTextContent());
    }

    /**
     * methods returns list of all the db's nodes
     * @return NodeList
     */
    public NodeList getNodeList() {
        return nodeList;
    }
}
