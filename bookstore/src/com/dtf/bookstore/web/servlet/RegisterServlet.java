package com.dtf.bookstore.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dtf.bookstore.exception.UserException;
import com.dtf.bookstore.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import com.dtf.bookstore.module.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//校验验证码
		request.setCharacterEncoding("UTF-8");
		String checkcode_client = request.getParameter("checkcode");
		System.out.println(checkcode_client);

		String checkcode_session = (String) request.getSession().getAttribute("checkcode_session");
		System.out.println(checkcode_session
		);
		 if (!checkcode_client.equals(checkcode_session) ){
				//校验失败，跳回注册页面
			 request.setAttribute("checkcode_err","验证码错误");
			 request.getRequestDispatcher("/register.jsp").forward(request,response);
			 return;
		 }

		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			System.out.println(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		System.out.println("参数转模型失败");
		}
		// 给无数据的属性赋值
		user.setActiveCode(UUID.randomUUID().toString());//激活码
		user.setRole("普通用户");//角色
		user.setRegistTime(new Date());//注册时间
		System.out.println(user);
		
		//注册
		UserService us = new UserService();
		try {
			us.register(user);
			request.getRequestDispatcher("/registersuccess.jsp").forward(request,response);
		} catch (UserException e) {
			e.printStackTrace();
			request.setAttribute("register_error",e.getMessage());
			request.getRequestDispatcher("/register.jsp").forward(request,response);
		}

	}


}
