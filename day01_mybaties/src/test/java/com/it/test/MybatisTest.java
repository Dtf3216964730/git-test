package com.it.test;


import com.it.dao.IUserDao;
import com.it.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    public static void main(String[] args) throws Exception {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml" );
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession session = factory.openSession();
        IUserDao userdao = session.getMapper(IUserDao.class);
        List<User> users = userdao.findAll();
        for (User user : users) {
            System.out.println(user);

        }
        session.close();
        in.close();
    }
}

