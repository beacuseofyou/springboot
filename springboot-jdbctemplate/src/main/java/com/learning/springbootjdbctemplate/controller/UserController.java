package com.learning.springbootjdbctemplate.controller;

import com.learning.springbootjdbctemplate.entity.User;
import com.learning.springbootjdbctemplate.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    IUserService service;

    @RequestMapping("/saveUser")
    public String saveUser(User user) {

        service.save(user);
        return "save user successful";
    }
}
