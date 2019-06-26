package com.service.impl;

import com.mapper.UserMapper;
import com.po.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    //注入用户Mapper
    @Autowired
    private UserMapper userMapper;

    /**
     * 查询所有用户
     * @return
     */
    @Override
    @Cacheable(value = "UserCache", key = "'user.getAllUsers'")
//    @CachePut(value = "UserCache", key = "'user.getAllUsers'")
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    /**
     * 删除用户
     * @param id
     */
    @Override
    @CacheEvict(value = "UserCache", key = "'user.getAllUsers'")
    public void deleteUser(Integer id) {
        userMapper.delete(id);
    }
}
