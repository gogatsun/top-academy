package com.example.programminglang.rdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// класс, отвечающий за установление соединения с БД
public class DbManager {
    // поля
    private final String dbHost;    // хост сервера БД
    private final String dbUser;    // пользователь
    private final String dbPassword;// пароль
    private final String dbName;  // имя БД

    // приватный статический флаг, указывающий на то, зарегистрирован ли драйвер
    private static boolean isDriverRegistered = false;

    // конструктор со всеми параметрами
    public DbManager(String dbHost, String dbUser, String dbPassword, String dbName) throws Exception {
        this.dbHost = dbHost;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
        this.dbName = dbName;
        // зарегистрировать драйвер
        registerDbDriver();
    }


    // метод регистрации драйвера
    private void registerDbDriver() throws Exception {
        if (!isDriverRegistered) {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            isDriverRegistered = true;
        }
    }

    // метод создания и получения объекта соединения с БД
    public Connection getDbConnection() throws SQLException {
        String url = "jdbc:mysql://" + dbHost + "/" + dbName;
        return DriverManager.getConnection(url, dbUser, dbPassword);
    }

    // Ctrl Shift Alt L
}
