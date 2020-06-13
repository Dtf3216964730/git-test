package com.dtf.dao.impl;

import com.dtf.dao.IUserDao;
import com.dtf.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements IUserDao {

    private SqlSessionFactory factory;
    public UserDaoImpl(SqlSessionFactory factory){
        this.factory = factory;
    }
    public List<User> findAll() {
        //根据factory获取sqlsession对象
        SqlSession session = factory.openSession(true);
        //根据sqlsession中的方法实现查询列表
        List<User> users = session.selectList("com.dtf.dao.IUserDao.findAll");//参数就是能获取配置信息的key
        //释放资源
        session.close();
        return users;
    }

    public void saveUser(User user) {
        SqlSession session = factory.openSession();
        session.insert("com.dtf.dao.IUserDao.saveUser",user);

        //释放资源
        session.close();
    }

    public void updateUser(User user) {
        SqlSession session = factory.openSession();
        session.update("com.dtf.dao.IUserDao.updateUser",user);

        //释放资源
        session.close();
    }

    @Override
    public void deleteUser(Integer userId) {
        SqlSession session = factory.openSession();
        session.delete("com.dtf.dao.IUserDao.deleteUser",userId);
        //提交事务

        //释放资源
        session.close();
    }


   @Override
    public User findById(Integer userId) {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用SqlSession中的方法，实现查询一个
        User user = session.selectOne("com.dtf.dao.IUserDao.findById",userId);
        //3.释放资源
        session.close();
        return user;
    }
    @Override
    public List<User> findByName(String username) {
        SqlSession session = factory.openSession();
         List<User> users= session.selectList("com.dtf.dao.IUserDao.findByName", username);
        //提交事务

        //释放资源
        session.close();
        return users;
    }

    public int findTotal() {
        SqlSession session = factory.openSession();
        //2.调用SqlSession中的方法，实现查询一个
        Integer total = session.selectOne("com.dtf.dao.IUserDao.findTotal");
        //3.释放资源
        session.close();
        return total;

    }
}
