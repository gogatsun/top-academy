package com.example.programminglang.servlet;

import com.example.programminglang.entity.Lang;
import com.example.programminglang.factory.DbFactory;
import com.example.programminglang.rdb.DbClient;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.security.InvalidParameterException;

@WebServlet(name="insertServlet", value="/insert")
public class InsertServlet extends HttpServlet {
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
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        try {
            String name = request.getParameter("name");
            String yearStr = request.getParameter("year");
            String paradigm = request.getParameter("paradigm");
            String level = request.getParameter("level");
            if (name == null || level == null || yearStr == null || paradigm == null) {
                throw new InvalidParameterException("One or more request params is null");
            }
            Integer year = Integer.valueOf(yearStr);
            Lang newLang = new Lang(null, name, year, paradigm, level);
            dbClient.insertLang(newLang);
            response.getWriter().println("Successfully");
        } catch (Exception e) {
            response.getWriter().println("error: " + e.getMessage());
        }
    }
}
