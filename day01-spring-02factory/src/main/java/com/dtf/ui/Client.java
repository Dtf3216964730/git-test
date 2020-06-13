package com.dtf.ui;

import com.dtf.factory.BeanFactory;
import com.dtf.service.IAccountService;
import com.dtf.service.impl.AccountServiceImpl;

/**
 * 模拟一个表现层，用于调用业务层
 */

public class Client {
    public static void main(String[] args) {
//        IAccountService as =new AccountServiceImpl();
        IAccountService as =(IAccountService ) BeanFactory.getBean("accountService");
        as.saveAccount();
    }
}
