package com.controller;

import com.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("thymeleaf")
public class ThymeleafController {

<<<<<<< HEAD

=======
    /**
     * @Description: index
     * @Params: model
     * @return: java.lang.String 
     * @Author: San Jinhong
     * @Date: 2018/9/3 10:45
     */
>>>>>>> 2df0857c1d36e6029642c5f8f28421f08b417d50
    @RequestMapping("/index")
    public String index(Model model, HttpServletRequest request){
        User user = new User();
        user.setId(1);
        user.setName("aaa");
        user.setAge(20);
        model.addAttribute("user", user);
        model.addAttribute("msg", "springboot thymeleaf");

        List<User> userList = new ArrayList<>();
        Map<Integer,User> userMap = new HashMap<>();
        User[] userArray = new User[10];
        for(int i=0; i<10; i++){
            User u = new User();
            u.setId(i);
            u.setName("name"+i);
            u.setAge(20+i);
            userList.add(u);
            userMap.put(i, u);
            userArray[i] = u;
        }
        model.addAttribute("userList", userList);
        model.addAttribute("userMap", userMap);
        model.addAttribute("userArray", userArray);

        model.addAttribute("sex", 1);
        model.addAttribute("gender", "2");

        request.setAttribute("name","sjh");

        request.getSession().setAttribute("key", "vlaue");

        model.addAttribute("date",new Date());

        model.addAttribute("str","2018-09-03 16:16:06");

        return "index";
    }

}
