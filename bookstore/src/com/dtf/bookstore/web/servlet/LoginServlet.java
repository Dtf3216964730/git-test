package com.dtf.bookstore.web.servlet;

import com.dtf.bookstore.exception.UserException;
import com.dtf.bookstore.module.User;
import com.dtf.bookstore.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserService us = new UserService();
        try {
            User user = us.login(username, password);
            request.getSession().setAttribute("user",user);

            if ("管理员".equals(user.getRole())){
                response.sendRedirect(request.getContextPath()+"/admin/login/home.jsp");
            }else{
                response.sendRedirect(request.getContextPath()+"/index.jsp");
            }
           // request.getRequestDispatcher("index.jsp").forward(request,response);
        } catch (UserException e) {
            e.printStackTrace();
            request.setAttribute("login_msg",e.getMessage());
              request.getRequestDispatcher("login.jsp").forward(request,response);
            //response.sendRedirect(request.getContextPath()+"/index.jsp");
        }


    }
}
