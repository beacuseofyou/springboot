package com.controller;

import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:学生Controller
 * @author:San Jinhong
 * @create:2018-08-27 17:16
 **/
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/findStudentById")
    public Object findAllStudents(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                studentService.findStudentById(2);
            }
        };
        //多线程测试一下缓存穿透问题
        ExecutorService executorService = Executors.newFixedThreadPool(25);
        for(int i = 0; i < 10000; i++){
            executorService.submit(runnable);
        }
        return studentService.findStudentById(1);
    }
}

