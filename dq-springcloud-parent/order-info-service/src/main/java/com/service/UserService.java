package com.service;

import com.entity.User;

public interface UserService {

    User addUser(User user);

    User findUserByName(String name);

}
