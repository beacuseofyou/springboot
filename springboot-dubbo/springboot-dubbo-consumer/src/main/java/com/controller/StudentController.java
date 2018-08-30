package com.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:San Jinhong
 * @create:2018-08-30 11:01:17
 **/
@RestController
@RequestMapping("/student")
public class StudentController {

    @Reference//(version = "1.0.0") // <dubbo:reference id="">
    private StudentService studentService;

    @RequestMapping("/findStudentById")
    public Object getStudent(@RequestParam ("id") Integer id) {
        return studentService.getUser(id);
    }

    @RequestMapping("/sayHi")
    public String sayHi(@RequestParam ("name") String name) {
        return studentService.sayHi(name);
    }
}
