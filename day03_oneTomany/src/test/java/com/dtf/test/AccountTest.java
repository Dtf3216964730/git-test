package com.dtf.test;

import com.dtf.dao.IAccountDao;
import com.dtf.dao.IUserDao;

import com.dtf.domain.Account;
import com.dtf.domain.AccountUser;
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




public class AccountTest {

    private InputStream in;
    private SqlSession sqlSession;
    private IAccountDao accountDao;

    @Before//用于在测试方法执行之前执行
    public void init() throws Exception {
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //获取sqlsession对象
        sqlSession = factory.openSession(true);
        //4.获取dao的代理对象
        accountDao  = sqlSession.getMapper(IAccountDao.class);

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
        //5.执行查询
        List<Account> accounts= accountDao.findAll();
        for (Account account : accounts) {
            System.out.println(account);

        }

    }
    /**
     * 查询所有账户及其用户名和地址
     */
    @Test
    public void testFindAllAccountUser() {
        //5.执行查询
        List<AccountUser> aus= accountDao.findAllAccount();
        for (Account au : aus) {
            System.out.println(au);

        }

    }




}



