package com.dtf.bookstore.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dtf.bookstore.module.Product;
import com.dtf.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

public class ProductDao {

    /**
     * 计算总记录数
     *
     * @param category 如果是null,是表的所有记录数
     * @return
     * @throws SQLException
     */
    public long count(String category) throws SQLException {
        //1.定义记录数变量0
        long count = 0;

        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        String sql = "select count(*) from products where 1=1";

        if (category != null && !"".equals(category)) {
            sql += " and category = ?";
            count = (long) qr.query(sql, new ScalarHandler(), category);
        } else {
            count = (long) qr.query(sql, new ScalarHandler());
        }

        return count;
    }


    /**
     * @param category 类型
     * @param page     当前页
     * @param pageSize 每页显示的条数
     * @return
     * @throws SQLException
     */
    public List<Product> findBooks(String category, int page, int pageSize) throws SQLException {

        //拼接sql和参数
        String sql = "select * from products where 1=1";

        List<Object> params = new ArrayList<Object>();

        if (category != null && !"".equals(category)) {
            sql += " and category = ?";
            params.add(category);
        }

        sql += " limit ?,?";
        int start = (page - 1) * pageSize;
        int length = pageSize;
        params.add(start);
        params.add(length);

        //执行
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        return qr.query(sql, new BeanListHandler<Product>(Product.class), params.toArray());
    }


    /**
     * 通过id查找商品
     *
     * @throws SQLException
     */
    public Product findBook(String id) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from products where id=?";
        return qr.query(sql, new BeanHandler<Product>(Product.class), id);
    }
}




    /**
     * 测试下Dao
     * @param args
     * @throws SQLException
     */
   /* public static void main(String[] args) throws SQLException {

        ProductDao dao = new ProductDao();
        //long count = dao.count(null);
        String category = "计算机";
        long count = dao.count(category);
//
        List<Product> books = dao.findBooks(category, 2, 4);
        for (Product b:books) {
            System.out.println(b);
        }
//        for(Product b : books){
//            System.out.println(b);
//        }
System.out.println(count);
  //      System.out.println(count);
    }
}*/
