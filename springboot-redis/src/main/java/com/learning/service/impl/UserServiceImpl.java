package com.learning.service.impl;

import com.learning.mapper.UserMapper;
import com.learning.model.User;
import com.learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<User> findAllUser() {
        List<User> userList = (List<User>) redisTemplate.opsForValue().get("allStudents");
        if(userList == null){
            System.out.println("缓存没有");
            userList = userMapper.selectAllUser();
            redisTemplate.opsForValue().set("allStudents", userList);
        }
        return userList;
    }
}
