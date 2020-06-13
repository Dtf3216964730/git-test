package com.dtf.service;

import com.dtf.domain.Account;

import java.util.List;

public interface AccountService {
    //查询所有账户信息
    public List<Account> findAll();
    //保存账户信息
    public void saveAccount(Account account);
}
