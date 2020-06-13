package com.dtf.dao;

import com.dtf.domain.Account;

import java.util.List;

/**
 * 账户的持久层接口
 */

public interface IAccountDao {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 查询一个
     * @return
     */

    Account findAccountById(Integer accountId);

    /**
     * 保存操作
     * @param account
     */
    void saveAcount(Account account);

    /**
     * 更新
     * @param account
     */
    void updateAcount(Account account);

    /**
     * 删除
     * @param account
     */
    void deleteAcount(Integer accountId);
}
