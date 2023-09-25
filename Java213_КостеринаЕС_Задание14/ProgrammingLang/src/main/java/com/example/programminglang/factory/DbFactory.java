package com.example.programminglang.factory;


import com.example.programminglang.rdb.DbClient;
import com.example.programminglang.rdb.DbManager;

// вспомогательный класс фабрики
public class DbFactory {

    public static DbManager prepareDbManager() throws Exception {
        // TODO: вынести конфиги подключения к БД в файл конфигураций
        String host = "127.0.0.1";
        String user = "root";
        String password = "root";
        String dbName = "db_programming_languages";
        return new DbManager(host, user, password, dbName);
    }

    public static DbClient prepareDbClient() throws Exception {
        return new DbClient(prepareDbManager());
    }
}
