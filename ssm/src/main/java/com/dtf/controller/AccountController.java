package com.dtf.controller;

import com.dtf.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 账户web
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;


    @RequestMapping("/findAll")
    public String findAll(){
        System.out.println("表现层：查出所有的账户信息");
//        调用service方法查询所有
        accountService.findAll();
        return "list";
    }
}
