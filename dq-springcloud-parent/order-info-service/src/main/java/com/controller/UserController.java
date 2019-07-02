package com.controller;

import com.entity.Department;
import com.entity.Role;
import com.entity.User;
import com.service.DepartmentService;
import com.service.RoleService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/findDepartmentById/{id}")
    public Department findDepartmentById(@PathVariable Long id){
        return departmentService.findDepartmentById(id);
    }

    @PutMapping("/updateDepartment")
    public Department updateDepartment(@RequestBody Department department){
        return departmentService.updateDepartment(department);
    }

    @DeleteMapping("/deleteDepartment")
    public void deleteDepartment(@PathVariable Long id){
        departmentService.deleteDepartment(id);
    }

    @PostMapping("/newAddRole")
    public Role newAddRole(@RequestBody Role role){
        return roleService.addRole(role);
    }


    @GetMapping("/findRoleByName")
    public Role findRoleByName(@RequestParam("name") String name){
        return roleService.findRoleByName(name);
    }

    @GetMapping("findRoleByNameLike")
    public List<Role> findRoleByNameLike(@RequestParam("name") String name){
        return roleService.findRoleByNameLike(name);
    }

    @GetMapping("/findRoleById/{id}")
    public Role findRoleById(@PathVariable Long id){
        return roleService.findById(id);
    }

    @PutMapping("/updateRole")
    public Role updateRole(@RequestBody Role role){
        return roleService.update(role);
    }

    @DeleteMapping("/deleteRole/id")
    public void deleteRole(@PathVariable Long id){
        roleService.delete(id);
    }

    @PostMapping("/newAddUser")
    public User newAddUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/findUser")
    public User findUser(@RequestParam(name = "name") String name){
        User user = userService.findUserByName(name);
        return user;
    }

    @GetMapping("/findUserAllPage")
    public Page<User> findUserAllPage(@RequestParam("pageNum") Integer pageNum,
                                      @RequestParam("pageSize") Integer pageSize){
        return userService.findUserAllPage(pageNum, pageSize);
    }

}
