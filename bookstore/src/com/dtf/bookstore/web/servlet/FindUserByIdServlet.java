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
@WebServlet("/findUserById")
public class FindUserByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("id");
        UserService us =new UserService();
        try {
            User user = us.findUserById(userid);
            request.setAttribute("u",user);
            request.getRequestDispatcher("/modifyuserinfo.jsp").forward(request,response);
        } catch (UserException e) {
            e.printStackTrace();
            response.getWriter().write(e.getMessage());
        }
    }
}
