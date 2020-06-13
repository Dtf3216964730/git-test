package com.dtf.service.Impl;

import com.dtf.dao.IAccountDao;
import com.dtf.dao.Impl.AccountDaoImpl;
import com.dtf.domain.Account;
import com.dtf.service.IAccountService;
import com.dtf.utils.TransactionManager;

import java.util.List;

/**
 * 账户的业务层实现类
 */
public class IAccountServiceImpl implements IAccountService {
   private IAccountDao accountDao;
   private TransactionManager txManager;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    @Override
    public List<Account> findAllAccount() {

        try {
            //开启事务
            txManager.beginTransaction();
            //执行从操作
            List<Account> accounts = accountDao.findAllAccount();
            //提交事务
            txManager.commit();
            //返回结果
            return accounts;
        } catch (Exception e) {
            //回滚事务
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            //释放连接
            txManager.release();

        }

    }

    @Override
    public Account findAccountById(Integer accountId) {
        try {
            //开启事务
            txManager.beginTransaction();
            //执行从操作
            Account account = accountDao.findAccountById(accountId);
            //提交事务
            txManager.commit();
            //返回结果
            return account;
        } catch (Exception e) {
            //回滚事务
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            //释放连接
            txManager.release();
        }

    }


    @Override
    public void saveAccount(Account account) {
        try {
            //开启事务
            txManager.beginTransaction();
            //执行从操作
            accountDao.saveAcount(account);
            //提交事务
            txManager.commit();

        } catch (Exception e) {
            //回滚事务
            txManager.rollback();
        } finally {
            //释放连接
            txManager.release();
        }

    }

    @Override
    public void updateAccount(Account account) {
        try {
            //开启事务
            txManager.beginTransaction();
            //执行从操作
            accountDao.updateAcount(account);
            //提交事务
            txManager.commit();

        } catch (Exception e) {
            //回滚事务
            txManager.rollback();
        } finally {
            //释放连接
            txManager.release();
        }


    }

    @Override
    public void deleteAccount(Integer accountId) {
        try {
            //开启事务
            txManager.beginTransaction();
            //执行从操作
            accountDao.deleteAcount(accountId);
            //提交事务
            txManager.commit();
        } catch (Exception e) {
            //回滚事务
            txManager.rollback();
        } finally {
            //释放连接
            txManager.release();
        }

    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        try {
            //开启事务
            txManager.beginTransaction();
            //执行从操作

            Account source = accountDao.findAccountByName(sourceName);
            //2.2根据名称查询转入账户
            Account target = accountDao.findAccountByName(targetName);
            //2.3转出账户减钱
            source.setMoney(source.getMoney()-money);
            //2.4转入账户加钱
            target.setMoney(target.getMoney()+money);
            //2.5更新转出账户
            accountDao.updateAcount(source);
            //2.5更新转入账户
            accountDao.updateAcount(target);
            //提交事务
            txManager.commit();

        } catch (Exception e) {
            //回滚事务
            txManager.rollback();
        } finally {
            //释放连接
            txManager.release();
        }
    }

}




