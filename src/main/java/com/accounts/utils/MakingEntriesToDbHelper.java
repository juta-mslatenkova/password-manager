package com.accounts.utils;

import com.accounts.model.Account;

import java.util.ArrayList;
import java.util.List;

public class MakingEntriesToDbHelper {

    public static boolean isLoginAndPassComboUnique(Account account, List<Account> accountsList) {
        return !searchForWebsiteAndLoginComboInDatabase(account.getWebsite(), account.getLogin(), accountsList);
    }

    public static boolean searchForWebsiteAndLoginComboInDatabase(String website2, String login2, List<Account> accountsList) {
        for (int i = 0; i < accountsList.size(); i++) {
            if (website2.equals(accountsList.get(i).getWebsite()) && login2.equals(accountsList.get(i).getLogin())) {
                return true;
            }
        }
        return false;
    }

    public static void printDataToConsole(Account account) {
        System.out.println(account.getWebsite() + " - " + account.getLogin() + " - " + account.getPassword());
    }

    public static void printAllFindings(List<Account> accountsList) {
        accountsList.forEach(account -> printDataToConsole(account));
    }

    public static void listOfDataForWeb(Account account) {
        System.out.println(account.getWebsite() + " - " + account.getLogin() + " - " + account.getPassword());
        List<String> result = new ArrayList<>();
        result.add(String.valueOf(account.getId()));
        result.add(account.getWebsite());
        result.add(account.getLogin());
        result.add(account.getPassword());
    }
}
