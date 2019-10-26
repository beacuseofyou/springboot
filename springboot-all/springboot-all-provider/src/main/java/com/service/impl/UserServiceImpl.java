package com.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.mapper.UserMapper;
import com.model.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author:San Jinhong
 * @create:2018-09-04 09:44:10
 **/
@Component //spring的注解
@Service   //dubbo的注解
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Override
    public List<User> getUserByPage(Map<String, Object> paramMap) {
        return userMapper.selectUserByPage(paramMap);
    }

    @Override
    public int getUserByTotal() {
        //整合redis报错了

        //设置key的序列化方式，采用字符串方式，可读性较好
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //取redis总数
        Integer totalRows = (Integer) redisTemplate.opsForValue().get("totalRows");
        if(null == totalRows){
            synchronized (this){
                totalRows = (Integer) redisTemplate.opsForValue().get("totalRows");
                if(null == totalRows){
                    totalRows = userMapper.selectUserByTotal();
                    redisTemplate.opsForValue().set("totalRows", totalRows);
                }
            }
        }
        return totalRows;
        //return userMapper.selectUserByTotal();
    }

    @Override
    public int addUser(User user) {
        //设置key的序列化方式，采用字符串方式，可读性较好
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        int add = userMapper.insertSelective(user);
        if(add > 0){
            //更新一下缓存的总数
            int totalRows = userMapper.selectUserByTotal();
            redisTemplate.opsForValue().set("totalRows", totalRows);
        }
        return add;
        //return userMapper.insertSelective(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public int deleteUser(int id) {
        //设置key的序列化方式，采用字符串方式，可读性较好
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        int delete = userMapper.deleteByPrimaryKey(id);
        if(delete > 0){
            //更新一下缓存的总数
            int totalRows = userMapper.selectUserByTotal();
            redisTemplate.opsForValue().set("totalRows", totalRows);
        }
        return delete;
        //return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
