package com.dtf.service.impl;

import com.dtf.dao.IAccountDao;
import com.dtf.dao.impl.AccountDaoImpl;
import com.dtf.factory.BeanFactory;
import com.dtf.service.IAccountService;

/**
 * 业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
 //   private IAccountDao accountDao = new AccountDaoImpl();
 private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");
    public void saveAccount(){
        accountDao.saveAccount();

    }
}
