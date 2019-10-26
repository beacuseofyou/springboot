package com.service;

import com.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    /**
     * @Description: 分页查询 
     * @Params: paramMap
     * @Return: java.util.List<com.model.User> 
     * @Author: San Jinhong
     * @Date: 2018/9/4 9:42
     */
    List<User> getUserByPage(Map<String, Object> paramMap);

    /**
     * @Description: 分页需要查询数据总数
     * @Params: 
     * @Return: int 
     * @Author: San Jinhong
     * @Date: 2018/9/4 9:52
     */
    int getUserByTotal();

    /**
     * @Description: 添加用户 
     * @Params: user
     * @Return: int 
     * @Author: San Jinhong
     * @Date: 2018/9/4 15:49
     */
    int addUser(User user);

    /**
     * @Description: 修改用户 
     * @Params: user
     * @Return: int 
     * @Author: San Jinhong
     * @Date: 2018/9/4 15:49
     */
    int updateUser(User user);

    /**
     * @Description: 删除用户 
     * @Params: id
     * @Return: int 
     * @Author: San Jinhong
     * @Date: 2018/9/4 15:49
     */
    int deleteUser(int id);

    User getUserById(Integer id);
}
