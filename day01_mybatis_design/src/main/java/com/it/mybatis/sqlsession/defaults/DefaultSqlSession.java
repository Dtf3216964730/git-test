package com.it.mybatis.sqlsession.defaults;

import com.it.cfg.Configuration;
import com.it.mybatis.sqlsession.SqlSession;
import com.it.mybatis.sqlsession.proxy.MapperProxy;
import com.it.mybatis.utils.DatasourceUtil;

import javax.sql.DataSource;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

public class DefaultSqlSession implements SqlSession {
    private Configuration cfg;
    private Connection connection;
    public DefaultSqlSession(Configuration cfg){
        this.cfg = cfg;
        connection = DatasourceUtil.getConnection(cfg);
    }
    /**
     * 用于创建代理对象
     * @param daoInterfaceClass
     * @param <T>
     * @return
     */
    @Override
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),new Class[]{daoInterfaceClass},new MapperProxy(cfg.getMappers(),connection));
        return null;
    }

    /**
     * 用于释放资源
     */
   @Override
    public void close() {
       if (connection != null){
           try {
               connection.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }

       }

    }
}
