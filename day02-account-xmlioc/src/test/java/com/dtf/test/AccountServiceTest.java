package com.dtf.test;

import com.dtf.domain.Account;
import com.dtf.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 使用junit单元测试，测试我们的配置
 */
public class AccountServiceTest {
    @Test
    public void testFindAll(){
        //1.获取容器
         ApplicationContext ac  = new ClassPathXmlApplicationContext("bean.xml");
         //2.得到业务层对象
        IAccountService as = ac.getBean("accountService",IAccountService.class);
        //3.执行方法
        List<Account> accounts = as.findAllAccount();
        //遍历
        for (Account account : accounts) {
            System.out.println(account);
            
        }

    }
     @Test
    public void testFindOne(){
         //1.获取容器
         ApplicationContext ac  = new ClassPathXmlApplicationContext("bean.xml");
         //2.得到业务层对象
         IAccountService as = ac.getBean("accountService",IAccountService.class);
         //3.执行方法
         Account account = as.findAccountById(1);
         System.out.println(account);

    }
     @Test
    public void testSave(){
         Account account = new Account();
         account.setName("dtf");
         account.setMoney(444554);
         //1.获取容器
         ApplicationContext ac  = new ClassPathXmlApplicationContext("bean.xml");
         //2.得到业务层对象
         IAccountService as = ac.getBean("accountService",IAccountService.class);
         as.saveAccount(account);


    }
     @Test
    public void testUpdate(){
         //1.获取容器
         ApplicationContext ac  = new ClassPathXmlApplicationContext("bean.xml");
         //2.得到业务层对象
         IAccountService as = ac.getBean("accountService",IAccountService.class);
         Account  account = as.findAccountById(4);
         account.setMoney(12312);
         as.updateAccount(account);

     }
     @Test
    public void testDelete(){
         //1.获取容器
         ApplicationContext ac  = new ClassPathXmlApplicationContext("bean.xml");
         //2.得到业务层对象
         IAccountService as = ac.getBean("accountService",IAccountService.class);
         as.deleteAccount(4);

    }



}
