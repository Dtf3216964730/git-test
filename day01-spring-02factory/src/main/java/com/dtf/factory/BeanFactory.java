package com.dtf.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 一个创建bean对象的工厂
 * bean：在计算机英语中，有可重用组件的定义
 */
public class BeanFactory {
    //定义一个properties对象
    private static Properties props;
    //使用静态代码块为properties对象赋值
    static {
        try {
            //实例化对象
            props=  new Properties();
            //获取properties文件中的流对象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties失败");
        }

    }

    /**
     * 根据bean的名称获取bean对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName) {
        Object bean = null;

        try {
            String beanPath = props.getProperty(beanName);
            bean = Class.forName(beanPath).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

}
