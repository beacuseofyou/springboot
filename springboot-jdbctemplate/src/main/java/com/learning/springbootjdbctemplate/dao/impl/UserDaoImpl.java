package com.learning.springbootjdbctemplate.dao.impl;

import com.learning.springbootjdbctemplate.dao.IUserDao;
import com.learning.springbootjdbctemplate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements IUserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insert(User user) {
        String sql = "insert into t_user(name, password) values(?,?)";
        jdbcTemplate.update(sql, user.getUserName(), user.getPassword());
    }
}