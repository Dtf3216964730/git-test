package com.dtf.dao;

import com.dtf.domain.Account;
import com.dtf.domain.AccountUser;

import java.util.List;

public interface IAccountDao {
    /**
     * 查询所有的账户
     * @return
     */
    List<Account> findAll();

    /**
     * 查询所有账户，并且带有用户名称和地址信息
     * @return
     */
    List<AccountUser> findAllAccount();
}
