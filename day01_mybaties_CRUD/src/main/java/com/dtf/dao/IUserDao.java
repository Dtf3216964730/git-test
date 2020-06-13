package com.dtf.dao;

import com.dtf.domain.QueryVo;
import com.dtf.domain.User;

import java.util.List;

/**
 *用户的持久层接口
 */
public interface IUserDao {
    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据id删除用户
     * @param userId
     */
    void delectUser(Integer userId);

    /**
     * 根据id查询用户
     * @param userId
     * @return
     */

    User findById(Integer userId);

    /**
     * 根据名称模糊查询用户信息
     * @param username
     * @return
     */

    List<User> findByName(String username);

    /**
     * 查询总的用户数
     * @return
     */
    int  findTotal();

    /**
     * 根据QueryVo中的条件查询用户
     * @param vo
     * @return
     * */

    /**
     * 根据queryVo中的条件查询
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);

}
