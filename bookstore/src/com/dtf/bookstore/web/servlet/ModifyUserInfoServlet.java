package com.dtf.bookstore.web.servlet;

import com.dtf.bookstore.module.User;
import com.dtf.bookstore.service.UserService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
@WebServlet("/modifyUserInfo")
public class ModifyUserInfoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取表单的参数
        User user = new User();
        try {
            BeanUtils.populate(user,request.getParameterMap());
            System.out.println(user);
            //修改
            UserService us = new UserService();
            us.modifyUserInfo(user);
            //跳转
            response.sendRedirect(request.getContextPath()+"/modifyUserInfoSuccess.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write(e.getMessage());
        }
        //
    }
}
