package com.dtf.ui;


import com.dtf.dao.IAccountDao;
import com.dtf.service.IAccountService;
import com.dtf.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟一个表现层，用于调用业务层
 */

public class Client {
    /**
     * 获取Spring的IOC核心容器，并根据id获取对象
     * @param args
     */
    public static void main(String[] args) {
        //获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //根据id获取bean对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
        IAccountDao adao = ac.getBean("accountDao",IAccountDao.class);
        System.out.println(as);
        System.out.println(adao);


        as.saveAccount();
    }
}
