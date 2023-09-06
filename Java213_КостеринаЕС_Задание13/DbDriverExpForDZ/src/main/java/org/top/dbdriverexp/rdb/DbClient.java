package org.top.dbdriverexp.rdb;
// DML операции

import org.top.dbdriverexp.entity.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;
import java.util.LinkedList;

public class DbClient {
    private final DBManager dbManager;
    public DbClient(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    public Collection<Book> selectAllBook() throws Exception {
        try (Connection connection = dbManager.getDbConnection()) {
            String sqlQuery = "SELECT * FROM books_t";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            LinkedList<Book> books = new LinkedList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String author = resultSet.getString(3);
                int pages = resultSet.getInt(4);
                Book book = new Book(id, name, author, pages);
                books.add(book);
            }
            return books;
        }
    }

    public Book selectBookId(int id) throws Exception {
        try (Connection connection  = dbManager.getDbConnection()) {
            String sqlQuery = "SELECT * FROM books_t where id=" + id + ";";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            Book book = null;
            while (resultSet.next()) {
                String name = resultSet.getString(2);
                String author = resultSet.getString(3);
                int pages = resultSet.getInt(4);
                book = new Book(id, name, author, pages);
            }
            return book;
        }
    }

}
