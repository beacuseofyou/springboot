package com;

import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootJavaApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    /*
    //方式一
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootJavaApplication.class, args);
        UserService userService = (UserService) context.getBean("userServiceImpl");
        String s = userService.sayHi("xxx");
        System.out.println(s);
    }
    */

    public static void main(String[] args){
        SpringApplication.run(SpringbootJavaApplication.class, args);
    }

    //方式二实现CommandLineRunner覆盖run方法
    @Override
    public void run(String... args) throws Exception {
        String s = userService.sayHi("jjj");
        System.out.println(s);
    }
}
