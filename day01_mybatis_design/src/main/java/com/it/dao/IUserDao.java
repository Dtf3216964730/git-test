package com.it.dao;

import com.it.domain.User;



import java.util.List;

public interface IUserDao {


    List<User> findAll();
}
