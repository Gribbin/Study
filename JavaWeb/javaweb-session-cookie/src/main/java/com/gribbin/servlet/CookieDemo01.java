package com.gribbin.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class CookieDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("GBK");
        resp.setCharacterEncoding("GBK");

        PrintWriter out = resp.getWriter();

        Cookie[] cookies = req.getCookies();
        if (null != cookies) {
            out.write("你上一次访问时间是：");
            for (Cookie c : cookies) {
                if (c.getName().equals("lastLoginTime")) {
                    Long lastLoginTime = Long.parseLong(c.getValue());
                    Date date = new Date(lastLoginTime);
                    out.write(date.toLocaleString());
                }
            }
        } else {
            out.write("第一次访问！");
        }

        //给服务器响应一个Cookie
        Cookie cookie = new Cookie("lastLoginTime", System.currentTimeMillis() + "");
        //cookie有效时间一天
        cookie.setMaxAge(24 * 60 * 60);
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
