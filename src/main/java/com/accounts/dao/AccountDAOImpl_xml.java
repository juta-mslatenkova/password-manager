package com.accounts.dao;

import com.accounts.model.Account;
import com.accounts.utils.MakingEntriesToDbHelper;
import com.accounts.utils.XmlDatabaseUtil;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

import static com.accounts.utils.XmlDatabaseUtil.*;
import static com.google.common.base.Preconditions.checkArgument;
import static com.accounts.model.Account.account;
import static com.accounts.model.Account.accountsList;

public class AccountDAOImpl_xml implements AccountDAO {

    private static final String DB_ROOT_TAG = "log-pass";
    public static final String PASSWORDTAG = "password";
    public static final String LOGINTAG = "login";
    public static final String WEBSITETAG = "website";

    private NodeList nodeList;

    //    public static Account account;
//    public static ArrayList<Account> accountsList;
    private static int dbEntryId;


    static {
        XmlDatabaseUtil.parseXML();
    }

    public AccountDAOImpl_xml() {
        nodeList = document.getElementsByTagName(DB_ROOT_TAG);
    }


    @Override
    public void save(Account account) {
        checkArgument(MakingEntriesToDbHelper.isLoginAndPassComboUnique(account, findAll()),
                "Oooops, data was not added as the website and login combination is not unique");
        // create new "log-pass" element" in the root node "logins-passwords"
        Element newDbEntry = document.createElement(DB_ROOT_TAG);
        root.appendChild(newDbEntry);

        // add element tags and texts to the new db entry
        Element element = document.createElement("id");
        element.appendChild(document.createTextNode(generateUniqueId()));
        newDbEntry.appendChild(element);

        element = document.createElement("website");
        element.appendChild(document.createTextNode(account.getWebsite()));
        newDbEntry.appendChild(element);

        element = document.createElement("login");
        element.appendChild(document.createTextNode(account.getLogin()));
        newDbEntry.appendChild(element);

        element = document.createElement("password");
        element.appendChild(document.createTextNode(account.getPassword()));
        newDbEntry.appendChild(element);

        saveDataToXML();
    }

    @Override
    public Account findById(long id) {
        checkArgument(isRequestedIdEqualToOneIndb(id), "No account with id = " + id + " was found");
        account = new Account(id, getAccount(dbEntryId).getWebsite(),
                getAccount(dbEntryId).getLogin(),
                getAccount(dbEntryId).getPassword());

        saveDataToXML();
        return account;
    }

    @Override
    public void update(Account account) {
        checkArgument(MakingEntriesToDbHelper.isLoginAndPassComboUnique(account, findAll()),
                "Oooops, data was not added as the website and login combination is not unique");
        checkArgument(isRequestedIdEqualToOneIndb(account.getId()),
                "No account with id = " + account.getId() + " was found");

        // set new content to the database entry
        document.getElementsByTagName("website").item(dbEntryId).setTextContent(account.getWebsite());
        document.getElementsByTagName("login").item(dbEntryId).setTextContent(account.getLogin());
        document.getElementsByTagName("password").item(dbEntryId).setTextContent(account.getPassword());

        saveDataToXML();
    }

    // TODO return dbEntryId as object
    private boolean isRequestedIdEqualToOneIndb(long id) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            String entryId = getDbEntryActualId(i, "id");
            // check if actual id equals to the requested id
            if (entryId.equals(String.valueOf(id))) {
//                account = new Account(i);
                dbEntryId = i;
                return true;
            }
        }
        return false;
    }

    @Override
    public void delete(Account account) {
        String id = String.valueOf(account.getId());

        for (int i = 0; i < nodeList.getLength(); i++) {
            String dbEntryId = getDbEntryActualId(i, "id");
            if (dbEntryId.equals(id)) {
                root.removeChild(root.getElementsByTagName(DB_ROOT_TAG).item(i));
            }

        }
        saveDataToXML();

        System.out.println("Deleted data for the id = " + id);

    }

    @Override
    public List<Account> findAll() {
        accountsList = new ArrayList<>();

        for (int i = 0; i < nodeList.getLength(); i++) {
            accountsList.add(getAccount(i));
        }

        return accountsList;
    }

    private String generateUniqueId() {
        return String.valueOf(System.currentTimeMillis());
    }

    private Account getAccount(int id) {
//TODO 'id' field added to return statement for servlet purposes
        String website = getDbEntryActualId(id, WEBSITETAG);
        String login = getDbEntryActualId(id, LOGINTAG);
        String password = getDbEntryActualId(id, PASSWORDTAG);

        return new Account(id, website, login, password);
    }


    private String getDbEntryActualId(int id, String tag) {
        return document.getElementsByTagName(tag).item(id).getTextContent();
    }
}