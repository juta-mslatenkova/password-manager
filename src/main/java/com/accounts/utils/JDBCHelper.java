package com.accounts.utils;

import java.sql.*;

public class JDBCHelper {

    static final String LOGIN = "postgres";
    static final String PASSWORD = "105479216";
    static final String DB_URL = "jdbc:postgresql://localhost:5433/logins-passwords";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, LOGIN, PASSWORD);
    }

    public static void init() throws ClassNotFoundException {
       // register JDBC driver
        Class.forName("org.postgresql.Driver");
    }


}
