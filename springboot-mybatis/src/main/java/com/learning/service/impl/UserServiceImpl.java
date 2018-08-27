package com.learning.service.impl;

import com.learning.mapper.StudentMapper;
import com.learning.model.Student;
import com.learning.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> findAllStudents() {
       return studentMapper.selectAllStudents();
    }

    @Override
    @Transactional
    public int modify() {
        Student student = new Student();
        student.setId(1);
        student.setName("张三-update");
        student.setAge(33);
        int update = studentMapper.updateByPrimaryKey(student);
        System.out.println(update);
        int a = 10/0;
        return update;
    }

    @Override
    public void remove(int id) {
        studentMapper.deleteByPrimaryKey(id);
    }
}
