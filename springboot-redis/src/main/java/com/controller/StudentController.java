package com.controller;

import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return studentService.findStudentById(1);
    }
}

