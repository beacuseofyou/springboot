package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = {"com.servlets", "com.filters"})
public class SpringbootServletApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootServletApplication.class, args);
    }
}
