package org.top.dbdriverexp.rdb;

// класс установления соединения с БД

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {

    private final String dbHost;
    private final String dbUser;
    private final String dbPassword;
    private final String dbName;

    private static boolean isDriver = false;

    public DBManager(String dbHost, String dbUser, String dbPassword, String dbName) throws Exception {
        this.dbHost = dbHost;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
        this.dbName = dbName;
        registerDbDriver();
    }

    // метод создания и получения объекта БД
    public Connection getDbConnection() throws Exception {
        String url = String.format("jdbc:mysql://%s/%s", dbHost, dbName);
        Connection connection;
        connection = DriverManager.getConnection(url, dbUser, dbPassword);
        return connection;
    }

    private void registerDbDriver() throws Exception {
        if (!isDriver) {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            isDriver = true;
        }
    }


}
