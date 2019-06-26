package com.service;

import com.po.User;

import java.util.List;

public interface UserService {

    /**
     * 查询所有用户
     * @return
     */
    List<User> getAllUsers();

    /**
     * 删除数据
     * @param id
     */
    void deleteUser(Integer id);

}
