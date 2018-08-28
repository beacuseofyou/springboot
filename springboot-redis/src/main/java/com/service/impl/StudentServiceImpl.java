package com.service.impl;

import com.mapper.StudentMapper;
import com.model.Student;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @description:service层实现
 * @author:San Jinhong
 * @create:2018-08-27 17:02
 **/

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Override
    public Student findStudentById(Integer id) {

        Student student = (Student) redisTemplate.opsForValue().get("student");
        if(null == student){
            student = studentMapper.selectByPrimaryKey(id);
            redisTemplate.opsForValue().set("student", student);
            System.out.println(redisTemplate.opsForValue().get("student"));
        }
        return student;
    }
}
