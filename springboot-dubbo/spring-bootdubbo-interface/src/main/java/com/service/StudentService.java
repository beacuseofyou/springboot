package com.service;

import com.model.Student;

public interface StudentService {

    String sayHi(String name);

    Student getUser(int id);
}
