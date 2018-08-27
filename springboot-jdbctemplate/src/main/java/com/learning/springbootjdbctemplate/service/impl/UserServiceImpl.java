package com.learning.springbootjdbctemplate.service.impl;

import com.learning.springbootjdbctemplate.dao.IUserDao;
import com.learning.springbootjdbctemplate.entity.User;
import com.learning.springbootjdbctemplate.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    public void save(User user){
        userDao.insert(user);
    }
}
