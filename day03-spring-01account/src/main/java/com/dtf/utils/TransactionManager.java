package com.dtf.utils;

import java.sql.SQLException;

/**
 * 和事务管理相关的工具类，包含了开启事务，提交事务，回滚事务和释放连接
 */
public class TransactionManager {
    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    /**
     * 开启事务
     */
    public void beginTransaction(){
        try {
            connectionUtils.getThreadConnecion().setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 提交事务
     */
    public void commit(){
        try {
            connectionUtils.getThreadConnecion().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public void rollback(){
        try {
            connectionUtils.getThreadConnecion().rollback();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放连接
     */
    public void release(){
        try {
            connectionUtils.getThreadConnecion().close();
            connectionUtils.removeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
