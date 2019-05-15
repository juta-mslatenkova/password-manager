package com.accounts.utils;

import com.accounts.dao.*;

public class DbInitFactory {

    DbInitFactory(){

    }

    public static AccountDAO getDatabase(String database) {
        switch (Database.valueOf(database)) {
            case XML:
                return new AccountDAOImpl_xml();
            case POSTGRESQL_HIBERNATE:
                return new AccountDAOImpl_PostgreSQL_Hibernate();
            case POSTGRESQL_JDBC:
                return new AccountDAOImpl_PostgreSQL_JDBC();
        }
        return null;
    }

    public enum Database {
        POSTGRESQL_HIBERNATE, XML, POSTGRESQL_JDBC
    }
}
