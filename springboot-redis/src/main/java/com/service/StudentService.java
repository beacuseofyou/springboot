package com.service;

import com.model.Student;

/**
 * @description:StudentService层
 * @author:San Jinhong
 * @create:2018-08-27 17:01
 **/
public interface StudentService {

    Student findStudentById(Integer id);
}
