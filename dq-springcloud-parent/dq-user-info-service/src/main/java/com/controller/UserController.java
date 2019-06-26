package com.controller;

import com.po.User;
import com.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api(value = "用户管理模块")
public class UserController {

    //注入用户Service
    @Autowired
    private UserService userService;

    /**
     * 查询所有用户
     * @return
     */
    @GetMapping("/userList")
    public List<User> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return users;
    }

    /**
     * 删除用户
     */
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        userService.deleteUser(id);
    }

}
