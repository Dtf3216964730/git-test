package com.dtf.test;

import com.dtf.dao.IUserDao;
import com.dtf.dao.impl.UserDaoImpl;
import com.dtf.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;


/**
 * 测试mybaties的crud操作
 */
public class
MybatiesTest {

    private InputStream in;
    private IUserDao userDao;

    @Before//用于在测试方法执行之前执行
    public void init() throws Exception {
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        //4.使用工厂对象创建dao对象
        userDao = new UserDaoImpl(factory);
    }

    @After//用于在测试方法执行之后执行
    public void destroy() throws Exception {
        //提交事务

        in.close();
    }

    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll() {
        //5.执行查询所有方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }

    }

    /**
     * 测试保存操作
     */
    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("modify User property");
        user.setAddress("北京市顺义区");
        user.setSex("男");
        user.setBirthday(new Date());
        System.out.println("保存操作之前：" + user);
        //5.执行保存方法
        userDao.saveUser(user);

        System.out.println("保存操作之后：" + user);
    }

    /**
     * 更新用户测试
     */
    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(52);
        user.setUsername("userdao1 impl update user");
        user.setAddress("北京市顺义区");
        user.setSex("女");
        user.setBirthday(new Date());

        //5.执行保存方法
        userDao.updateUser(user);
    }

    /**
     * 删除用户测试
     */
    @Test
    public void testDelete(){
        //5.执行删除方法
        userDao.deleteUser(48);
    }

    /**
     * 根据id查询用户
     */
    @Test
    public void testFindOne(){
        //5.执行查询一个方法
        User  user = userDao.findById(46);
        System.out.println(user);
    }


    /**
     * 模糊查询
     */
    @Test
    public void testFindByName() {
        List<User> users = userDao.findByName("%王%");
        for (User user : users) {
            System.out.println(user);

        }
    }

    /**
     * 记录用户总记录条数
     */
    @Test
    public void testFindTotal() {
        int total = userDao.findTotal();
        System.out.println(total);
    }

}



