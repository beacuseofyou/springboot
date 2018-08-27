package com.learning.service.impl;

import com.learning.entity.User;
import com.learning.repository.IUserRepository;
import com.learning.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserRepository repository;

    @Override
    public User getUser(Integer id) {
        return repository.getUser(id);
    }
}
