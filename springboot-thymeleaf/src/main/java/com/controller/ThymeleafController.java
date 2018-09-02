package com.controller;

import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("thymeleaf")
public class ThymeleafController {

    /*
     *@Description: 
     *@Params:
     *@Return: 
     *@Auth: San Jinhong
     *@CreateTime: 2018/9/2 22:43 
     */
    @RequestMapping("/index")
    public String index(Model model){
        User user = new User();
        user.setId(1);
        user.setName("aaa");
        user.setAge(20);
        model.addAttribute("user", user);
        model.addAttribute("msg", "springboot thymeleaf");
        return "index";
    }

}
