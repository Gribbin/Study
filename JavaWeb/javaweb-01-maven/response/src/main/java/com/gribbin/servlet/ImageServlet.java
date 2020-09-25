package com.gribbin.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //如何让浏览器3秒刷新一次
        resp.setHeader("refresh", "3");
        //在内存中创建一张图片
        BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
        //得到图片画笔
        Graphics2D g = (Graphics2D) image.getGraphics();
        //设置图片背景色
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 80, 20);
        //绘写图片数字
        g.setColor(Color.BLUE);
        g.setFont(new Font(null, Font.BOLD, 20));
        g.drawString(randomNum(), 20, 20);
        g.setColor(c);
        //告诉浏览器，这个请求用图片的方式打开
        resp.setContentType("image/jpeg");
        //网站存在缓存，不让浏览器缓存
        resp.setDateHeader("Expires", -1);
        resp.setHeader("Cache-Control", "no-cache");
        resp.setHeader("Pragma", "no-cache");
        //把图片写给浏览器
        ImageIO.write(image, "jpg", resp.getOutputStream());
    }

    private String randomNum() {
        String num = new Random().nextInt(9999) + "";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 4 - num.length(); i++) {
            sb.append(0);
        }
        System.out.println(sb.toString() + num);
        return sb.toString() + num;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
