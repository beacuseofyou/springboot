package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:San Jinhong
 * @create:2018-08-31 15:55:12
 **/
@Controller
@RequestMapping("/war")
public class WarController {

    @RequestMapping("/json")
    @ResponseBody
    public Object json(){
        Map<String, Object> json = new HashMap<>();
        json.put("name","sjh");
        json.put("age",20);
        return json;
    }

    @RequestMapping("/jsp")
    public String jsp(Model model){
        model.addAttribute("name","sjh");
        return "index";
    }
}
