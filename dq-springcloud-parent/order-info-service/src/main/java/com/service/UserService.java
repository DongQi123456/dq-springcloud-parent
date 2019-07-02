package com.service;

import com.entity.User;
import org.springframework.data.domain.Page;

public interface UserService {

    User addUser(User user);

    User findUserByName(String name);

    Page<User> findUserAllPage(Integer pageNum, Integer pageSize);

}
