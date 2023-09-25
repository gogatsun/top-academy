package com.example.programminglang.rdb;


import com.example.programminglang.entity.Lang;

import java.sql.*;
import java.util.Collection;
import java.util.LinkedList;

public class DbClient {

    private final DbManager dbManager;

    public DbClient(DbManager dbManager) {
        this.dbManager = dbManager;
    }

    // операции с данными из БД
    // 1. получение всех студентов
    public Collection<Lang> selectAllLang() throws SQLException {

        try (Connection connection = dbManager.getDbConnection()) {
            String sql = "SELECT * FROM languages_t;";            // строка sql запроса
            Statement statement = connection.createStatement(); // выражение для работы с БД
            ResultSet result = statement.executeQuery(sql);     // выполнение запроса с табличным результатом
            LinkedList<Lang> languages = new LinkedList<>();
            // прочитать результат
            while (result.next()) {
                // извлекаем данные очередной строки таблицы результата
                Lang lang = readFromRow(result);
                languages.add(lang);
            }
            return languages;
        }
    }

    // 2. получить студента по id
    public Lang selectById(Integer id) throws SQLException {
        try (Connection connection = dbManager.getDbConnection()) {
            String sql = "SELECT * FROM languages_t WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                return readFromRow(result);
            }
            return null;
        }
    }

    // 3. добавить нового студента в таблицу
    public void insertLang(Lang lang) throws SQLException {
        try (Connection connection = dbManager.getDbConnection()) {
            String sql = "INSERT INTO languages_t (name, year, paradigm, level) VALUES (?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, lang.getName());
            preparedStatement.setInt(2, lang.getYear());
            preparedStatement.setString(3, lang.getParadigm());
            preparedStatement.setString(4, lang.getLevel());
            executeUpdateQuery(preparedStatement);
        }
    }

    // 4. удаление студента (удаление записи из таблицы по id)
    public void deleteLangById(Integer id) throws SQLException {
        try (Connection connection = dbManager.getDbConnection()) {
            String sql = "DELETE FROM languages_t WHERE id = " + id + ";";
            executeUpdateQuery(sql, connection);
        }
    }

    // 5. обновление данных студента
    public void updateLang(Lang lang) throws SQLException {
        try (Connection connection = dbManager.getDbConnection()) {
            String sql = String.format("UPDATE languages_t\n" +
                    "SET name='%s', year='%d'\n" +
                    "WHERE id = %d;", lang.getName(), lang.getYear(), lang.getId());
            executeUpdateQuery(sql, connection);
        }
    }

    private void executeUpdateQuery(String sql, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        int rowsAffected = statement.executeUpdate(sql);
        if (rowsAffected == 0) {
            throw new SQLException("0 rows affected after execute update");
        }
    }

    private void executeUpdateQuery(PreparedStatement preparedStatement) throws SQLException {
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected == 0) {
            throw new SQLException("0 rows affected after execute update");
        }
    }

    private Lang readFromRow(ResultSet result) throws SQLException {
        Integer id = result.getInt(1);
        String name = result.getString(2);
        Integer year = result.getInt(3);
        String paradigm = result.getString(4);
        String level = result.getString(5);
        return new Lang(id, name, year, paradigm, level);
    }
}
