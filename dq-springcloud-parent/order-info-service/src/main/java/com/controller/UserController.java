package com.controller;

import com.entity.Department;
import com.entity.Role;
import com.entity.User;
import com.service.DepartmentService;
import com.service.RoleService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @PostMapping("/newAddDepartment")
    public Department newAddDepartment(@RequestBody Department department){
        return departmentService.addDepartment(department);
    }

    @PostMapping("/newAddRole")
    public Role newAddRole(@RequestBody Role role){
        return roleService.addRole(role);
    }

    @PostMapping("/newAddUser")
    public User newAddUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/findUser")
    public User findUser(@RequestParam(name = "name") String name){
        return userService.findUserByName(name);
    }

}
