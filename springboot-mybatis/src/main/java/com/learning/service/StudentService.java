package com.learning.service;

import com.learning.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    List<Student> findAllStudents();

    int modify();

    void remove(int id);
}
