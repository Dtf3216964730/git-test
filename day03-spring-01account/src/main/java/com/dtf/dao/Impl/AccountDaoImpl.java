package com.dtf.dao.Impl;

import com.dtf.dao.IAccountDao;
import com.dtf.domain.Account;
import com.dtf.service.IAccountService;
import com.dtf.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;
/**
 * 账户的持久层实现类
 */
public class AccountDaoImpl implements IAccountDao {
    private QueryRunner runner;
    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    @Override
    public List<Account> findAllAccount() {
        try {
            return runner.query(connectionUtils.getThreadConnecion(),"select * from account",new BeanListHandler<Account>(Account.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccountById(Integer accountId) {
        try {
            return runner.query(connectionUtils.getThreadConnecion(),"select * from account where id = ?",new BeanHandler<Account>(Account.class),accountId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAcount(Account account) {
        try {
             runner.update(connectionUtils.getThreadConnecion(),"insert into account(name,money)values(?,?)",account.getName(),account.getMoney());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAcount(Account account) {
        try {
            runner.update(connectionUtils.getThreadConnecion(),"update account set name = ?,money = ? where id = ?",account.getName(),account.getMoney(),account.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAcount(Integer accountId) {
        try {
            runner.update(connectionUtils.getThreadConnecion(),"delete from account where id = ?",accountId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }



    @Override
    public Account findAccountByName(String accountName) {
        try {
            List<Account> accounts= runner.query(connectionUtils.getThreadConnecion(),"select * from account where name = ?",new BeanListHandler<Account>(Account.class),accountName);
            if(accounts == null || accounts.size()==0){
                return null;
            }
            if (accounts.size() > 1){
                throw new RuntimeException("结果集不唯一");
            }
            return accounts.get(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
