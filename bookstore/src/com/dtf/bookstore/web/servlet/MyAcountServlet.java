package com.dtf.bookstore.web.servlet;

import com.dtf.bookstore.module.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/myacount")
public class MyAcountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
            //未登录进行登录界面
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }else{
            //进入我的帐号页面
            request.getRequestDispatcher("/myAccount.jsp").forward(request, response);
        }


    }
}
