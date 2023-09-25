package com.example.programminglang.servlet;

import com.example.programminglang.entity.Lang;
import com.example.programminglang.factory.DbFactory;
import com.example.programminglang.rdb.DbClient;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

@WebServlet(name="searchServlet", value="/search")
public class SearchServlet extends HttpServlet {
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
            Integer id = Integer.valueOf(request.getParameter("id"));      // 1. ИЗВЛЕЧЕНИЕ ДАННЫХ
            Lang lang = dbClient.selectById(id);                   // 2. ВЫЗОВ ЛОГИКИ
            response.getWriter().println(lang);                              // 3. ЗАПИСТЬ ОТВЕТА
            response.getWriter().println("Successfully");
        } catch (Exception e) {
            response.getWriter().println("error: " + e.getMessage());
        }
    }
}
