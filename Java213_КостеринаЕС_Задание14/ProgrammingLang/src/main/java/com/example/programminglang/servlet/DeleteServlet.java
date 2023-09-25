package com.example.programminglang.servlet;

import com.example.programminglang.factory.DbFactory;
import com.example.programminglang.rdb.DbClient;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

@WebServlet(name="deleteServlet", value="/delete")
public class DeleteServlet extends HttpServlet {

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
            dbClient.deleteLangById(id);                   // 2. ВЫЗОВ ЛОГИКИ
            response.getWriter().println("Successfully");  // 3. ЗАПИСТЬ ОТВЕТА
        } catch (Exception e) {
            response.getWriter().println("error: " + e.getMessage());
        }
    }
}
