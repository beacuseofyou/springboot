package com.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.model.User;
import com.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author:San Jinhong
 * @create:2018-09-04 10:35:24
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @Reference
    private UserService userService;

    @RequestMapping("/index")
    public String index(Model model,
            @RequestParam(value = "curPage", required = false) Integer curPage) {

        if(null == curPage || curPage < 1){
            curPage = 1;
        }

        //每页展示数据数
        int pageSize = 5;

        //总数
        int totalRows = userService.getUserByTotal();
        //计算分页
        int totalPages = totalRows / pageSize;
        //可能有余数
        int left = totalRows % pageSize;
        if(left  > 0) {
            totalPages = totalPages + 1;
        }

        if(curPage > totalPages){
            curPage = totalPages;
        }

        int startRow = (curPage - 1) * pageSize;
        Map<String, Object> paramMap = new ConcurrentHashMap<>();
        paramMap.put("startRow",startRow);
        paramMap.put("pageSize", pageSize);
        List<User> userList = userService.getUserByPage(paramMap);

        model.addAttribute("userList", userList);
        model.addAttribute("curPage", curPage);
        model.addAttribute("totalPages", totalPages);
        //跳转到模板页面
        return "index";
    }

    /**
     * @Description: 跳转到添加用户页面
     * @Params: null
     * @Return:  
     * @Author: San Jinhong
     * @Date: 2018/9/4 15:43
     */
    @RequestMapping("/toAdd")
    public String toAddUser(){
        return "addUser";
    }

    /**
     * @Description: 添加用户/修改用户
     * @Params: 
     * @Return: void 
     * @Author: San Jinhong
     * @Date: 2018/9/4 15:44
     */
    @RequestMapping("/add")
    public String add(User user) {

        Integer id = user.getId();
        if(null == id){
            //添加用户
            userService.addUser(user);
        } else {
            //修改用户
            userService.updateUser(user);
        }
        return "redirect:index";
    }

    /**
     * @Description: 跳转到修改页面
     * @Params:
     * @Return: void
     * @Author: San Jinhong
     * @Date: 2018/9/4 15:45
     */
    @RequestMapping("/toModify")
    public String modify(Model model, @RequestParam("id") Integer id){
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "addUser";
    }

    /**
     * @Description: 删除用户
     * @Params: 
     * @Return: void 
     * @Author: San Jinhong
     * @Date: 2018/9/4 15:45
     */
    @RequestMapping("/remove")
    public String remove(@RequestParam(value = "id") Integer  id){
        userService.deleteUser(id);
        return "redirect:index";
    }
}
