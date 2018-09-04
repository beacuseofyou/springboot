package com.controller;

import com.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("thymeleaf")
public class ThymeleafController {


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
