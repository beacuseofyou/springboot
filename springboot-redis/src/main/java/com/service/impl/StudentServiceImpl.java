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

    //泛型只能写<String,String>或者<Object,Object>
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    /*@Override
    public *//*synchronized*//* Student findStudentById(Integer id) {

        //高并发条件下此处可能存在缓存穿透问题，可用多线程synchronized
        //查询缓存
        Student student = (Student) redisTemplate.opsForValue().get("student");
        //双重检测
        //查询的缓存1和查询的缓存2交替是什么原因
        if (null == student) {
            synchronized (this) {
                student = (Student) redisTemplate.opsForValue().get("student");
                if (null == student) {
                    System.out.println("查询的数据库.......");
                    student = studentMapper.selectByPrimaryKey(id);
                    redisTemplate.opsForValue().set("student", student);
                } else {
                    System.out.println("查询的缓存1.....");
                }
            }
        } else {
            System.out.println("查询的缓存2.....");
        }
        return student;
    }*/

    @Override
    public synchronized Student findStudentById(Integer id) {

        //高并发条件下此处可能存在缓存穿透问题，可用多线程synchronized
        //查询缓存
        Student student = (Student) redisTemplate.opsForValue().get("student");
        if (null == student) {
            System.out.println("查询的数据库.......");
            student = studentMapper.selectByPrimaryKey(id);
            redisTemplate.opsForValue().set("student", student);
        } else {
            System.out.println("查询的缓存1.....");
        }
        return student;
    }
}
