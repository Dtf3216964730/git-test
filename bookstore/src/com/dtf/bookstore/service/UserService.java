package com.dtf.bookstore.service;

import java.sql.SQLException;

import com.dtf.bookstore.dao.UserDao;
import com.dtf.bookstore.exception.UserException;
import com.dtf.bookstore.module.User;
import com.dtf.utils.SendJMail;


public class UserService {
	UserDao userdao =new UserDao();
	public void register(User user) throws UserException {
		
		try {
			userdao.addUser(user);

			//发送激活邮件
			String link = "http://localhost:8080/bookstore/active?activeCode="+user.getActiveCode();//项目发布的时候改成域名
			String html = "<a href = \""+link+ "\">欢迎你注册网上书城账号</a>";
			System.out.println(html);
			SendJMail.sendMail(user.getEmail(), html);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new  UserException("用户注册失败");
		}
		
	}
	//激活用户
	User user = null;
	public void activeUser(String activeCode) throws UserException {
		try {
			user = new UserDao().findUserByActiveCode(activeCode);
		}catch (Exception e){
			throw new UserException("激活失败");
		}
		if (user == null){
			throw new UserException("用户不存在");
		}
		if (user != null&& user.getState()==1){
			throw new UserException("用户已激活");
		}
		try {
			userdao.updateState(activeCode);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public User login(String username,String password) throws UserException {
		try {
			User user = userdao.findUserByUsernameAndPassword(username, password);
			if (user == null){
				throw new UserException("用户名或密码不正确");
			}
			if (user.getState()==0){
				throw new UserException("用户未激活，情先登录邮箱进行激活");
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("登录失败");
		}
	}
	public User findUserById(String id) throws UserException {
		try {
			User user = userdao.findUserById(id);
			if (user == null){
				throw new UserException("用户不存在");
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("未知错误");
		}
	}
	public void modifyUserInfo(User user) throws UserException {
		try {

			userdao.updateUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("未知错误");
		}
	}

}
