package com.service.impl;

import com.entity.User;
import com.repository.UserRepository;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserByName(String name) {
        return userRepository.readByName(name);
    }

    @Override
    public Page<User> findUserAllPage(Integer pageNum, Integer pageSize) {

        Pageable pageable = new PageRequest(pageNum, pageSize, new Sort(Sort.Direction.DESC, "id"));

        return userRepository.findAll(pageable);
    }
}
