package com.sfit.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ServletDemo05 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InputStream ras = this.getServletContext().getResourceAsStream("/WEB-INF/classes/test.properties");

        Properties prop = new Properties();
        prop.load(ras);
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");

        resp.getWriter().print(username + "\tlove" + password);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
