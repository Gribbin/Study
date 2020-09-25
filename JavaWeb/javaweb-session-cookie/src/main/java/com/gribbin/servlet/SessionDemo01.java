package com.gribbin.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        //获得session
        HttpSession session = req.getSession();
        //往session中存东西
        session.setAttribute("name", "大秦");
        //获取sessionID
        String sessionId = session.getId();
        //判断session是否新创建
        if (session.isNew()) {
            resp.getWriter().write("session创建成功，ID：" + sessionId);
        } else {
            resp.getWriter().write("session已经存在，ID：" + sessionId);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
