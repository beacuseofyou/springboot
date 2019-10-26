package com.service.impl;

import com.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author:San Jinhong
 * @create:2018-08-31 15:00:28
 **/
@Service
public class UserServiceImpl implements UserService {
    @Override
    public String sayHi(String name) {
        return "Hi," + name;
    }
}
