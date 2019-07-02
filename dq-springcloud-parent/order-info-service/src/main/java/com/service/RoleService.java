package com.service;

import com.entity.Role;

import java.util.List;

public interface RoleService {

    Role addRole(Role role);

    Role findRoleByName(String name);

    List<Role> findRoleByNameLike(String name);

    Role findById(Long id);

    Role update(Role role);

    void delete(Long id);

}
