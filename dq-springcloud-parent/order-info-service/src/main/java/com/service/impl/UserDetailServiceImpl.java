package com.service.impl;

import com.entity.Role;
import com.entity.User;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名去查找用户信息
        User user = userRepository.findByName(username);

        if (ObjectUtils.isEmpty(user))
            throw new UsernameNotFoundException(String.format("Not user Found with '%s'", username));

        //根据用户id查询角色
        List<Role> roles = user.getRoles();
        return new org.springframework.security.core.userdetails.User(user.getName(),passwordEncoder.encode(user.getPassword()),getGrantedAuthority(roles));
    }

    /***
     * @Description: 获取角色权限
     * @Param: [roles]
     * @return: java.util.List<org.springframework.security.core.GrantedAuthority>
     * @Author: wangzh
     * @Date: 2019/3/21
     */
    private List<GrantedAuthority> getGrantedAuthority(List<Role> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>(roles.size());

        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

}
