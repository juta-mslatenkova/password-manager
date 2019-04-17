package com.accounts.utils;

import com.accounts.model.Account;

import java.util.List;

public class DatabaseEntriesCheck {

    public static boolean isLoginAndPassComboUnique(Account account, List<Account> accountsList) {
        return !searchForWebsiteAndLoginComboInDatabase(account.getWebsite(), account.getLogin(), accountsList);
    }

    public static boolean searchForWebsiteAndLoginComboInDatabase(String website2, String login2, List<Account> accountsList) {
        for (int i = 0; i < accountsList.size(); i++) {
            if (website2.equals(accountsList.get(i).getWebsite())) {
                if (login2.equals(accountsList.get(i).getLogin())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void printDataToConsole(Account account) {
        System.out.println(account.getWebsite() + " - " + account.getLogin() + " - " + account.getPassword());
    }

    public static void printAllFindings(List<Account> accountsList) {
        for (Account acc : accountsList) {
            DatabaseEntriesCheck.printDataToConsole(acc);
        }
    }
}
