package com;

import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootJavaApplication {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootJavaApplication.class, args);
        UserService userService = (UserService) context.getBean("userServiceImpl");
        String s = userService.sayHi("xxx");
        System.out.println(s);
    }
}
