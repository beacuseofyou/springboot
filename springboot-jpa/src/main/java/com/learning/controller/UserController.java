package com.learning.controller;

import com.learning.entity.User;
import com.learning.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    IUserService service;

    @RequestMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return service.getUser(id);
    }
}
