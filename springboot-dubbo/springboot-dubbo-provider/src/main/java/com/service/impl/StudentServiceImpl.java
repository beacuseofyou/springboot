package com.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.mapper.StudentMapper;
import com.model.Student;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description:User实现
 * @author:San Jinhong
 * @create:2018-08-29 15:21
 **/
@Component //由于存在dubbo的@Service注解，所以用@Component将StudentServiceImpl注解成为一个bean
@Service//(version = "1.0.0",timeout = 10000) //dubbo注解<dubbo:service interface=... ref=.. version=>
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public String sayHi(String name) {
        return "Hi,SpringBoot:" + name;
    }

    @Override
    public Student getUser(int id) {
        return studentMapper.selectByPrimaryKey(id);
    }
}
