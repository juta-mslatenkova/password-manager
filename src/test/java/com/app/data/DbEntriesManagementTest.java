package com.app.data;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class DbEntriesManagementTest {

    @Test
    public void should_return_correct_array_of_data_toBe_enteredInto_Db(){
        // setup
        DatabaseHelper.parseXML();

        String id = "any";
        String website = "test_website";
        String login = "test_login";
        String password = "test_password";
        List<String> expected = new ArrayList<>();
        expected.add(website); expected.add(login); expected.add(password);

        // exercise
        List<String> result = DbEntriesManagement.setDataForTheNewEntry(website, login, password);
        result.remove(0); // removing unique if from list

        // verify
        assertIterableEquals(expected, result);

    }

    @Test
    public void are_areSiteAndPasswordComboUnique(){

    }
}
