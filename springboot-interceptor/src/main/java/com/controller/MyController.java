package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:San Jinhong
 * @create:2018-08-30 15:22:15
 **/
@RestController
public class MyController {

    @RequestMapping("/boot/hello")
    public String hello(){
        return "hello";
    }
    @RequestMapping("/boot/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/boot/other")
    public String other(){
        return "other";
    }
}
