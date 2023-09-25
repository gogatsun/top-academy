package com.example.programminglang.servlet;


import com.example.programminglang.entity.Lang;
import com.example.programminglang.factory.DbFactory;
import com.example.programminglang.rdb.DbClient;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.Collection;

@WebServlet(name="findServlet", value="/all")
public class FindAllServlet extends HttpServlet {

    private DbClient dbClient;

    @Override
    public void init() {
        try {
            dbClient = DbFactory.prepareDbClient();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        try {
            Collection<Lang> language = dbClient.selectAllLang();    // получить всех студентов
            // вывести студентов
            for (Lang lang : language) {
                response.getWriter().println(lang + "\n <br>");
            }
            response.getWriter().println("Successfully");
        } catch (Exception e) {
            response.getWriter().println("error: " + e.getMessage());
        }
    }
}
