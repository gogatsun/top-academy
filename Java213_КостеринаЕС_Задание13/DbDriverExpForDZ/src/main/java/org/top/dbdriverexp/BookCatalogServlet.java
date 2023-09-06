package org.top.dbdriverexp;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.top.dbdriverexp.entity.Book;
import org.top.dbdriverexp.rdb.DBManager;
import org.top.dbdriverexp.rdb.DbClient;

import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "bookCatalog", value = "/book-catalog")
public class BookCatalogServlet extends HttpServlet {

    private DbClient dbClient;

    @Override
    public void init() {
        // todo: вынести конфиги подключения к БД в файл конфигурации
        String host = "127.0.0.1";
        String user = "root";
        String password = "root";
        String bdName = "db_book_catalog";
        try {
            dbClient = new DbClient(new DBManager(host,user,password,bdName));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");

        try {
            Collection<Book> books = dbClient.selectAllBook();
            resp.getWriter().println("<h2>All Book</h2><br>");
            for (Book book : books) {
                resp.getWriter().printf("<span>%s</span> <br/>", book);
            }
        } catch (Exception ex) {
            resp.getWriter().println("Database error:" + ex.getMessage());
        }
    }

    @Override
    public void destroy() {
    }
}
