package com.it.mybatis.sqlsession;

public interface SqlSession {
    /**
     * 根据参数创建代理对象
     * @param daoInterfaceClass
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> daoInterfaceClass);

    void close();


}
