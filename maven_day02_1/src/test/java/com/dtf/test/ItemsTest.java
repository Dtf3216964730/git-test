package com.dtf.test;

import com.dtf.domain.Items;
import com.dtf.service.ItemsServices;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ItemsTest {
    @Test
    public void findById(){
        //获取spring容器
        ApplicationContext ac =new ClassPathXmlApplicationContext("applicationContext.xml");
//        //dao测试
//        //从容器中拿到所需的dao代理对象
//        ItemsDao dao = ac.getBean(ItemsDao.class);
//        //调用方法
//        Items item = dao.findById(1);
//        System.out.println(item.getName());
        ItemsServices services = ac.getBean(ItemsServices.class);
        Items items = services.findById(1);
        System.out.println(items.getName());

    }
}
