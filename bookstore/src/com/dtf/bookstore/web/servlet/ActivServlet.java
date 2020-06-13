package com.dtf.bookstore.web.servlet;

import com.dtf.bookstore.exception.UserException;
import com.dtf.bookstore.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/active")
public class ActivServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("context-type","text/html;charset=utf-8");
        String activeCode = request.getParameter("activeCode");
        UserService us = new UserService();
        try {
            us.activeUser(activeCode);
            response.getWriter().write("激活成功");
        } catch (UserException e) {
            e.printStackTrace();
            response.getWriter().write(e.getMessage());
        }
    }
}
