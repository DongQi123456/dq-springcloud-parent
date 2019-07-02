package com.service.impl;

import com.entity.Role;
import com.repository.RoleRepository;
import com.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    @CachePut(value = "roles", key = "#p0.id")
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role findRoleByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public List<Role> findRoleByNameLike(String name) {
        name = "%" + name + "%";
        return roleRepository.findByNameLike(name);
    }

    @Override
    @Cacheable(value = "roles", key = "#id")
    public Role findById(Long id) {
        return roleRepository.findOne(id);
    }

    @Override
    @CachePut(value = "roles", key = "#role.id")
    public Role update(Role role) {
        return roleRepository.save(role);
    }

    @Override
    @CacheEvict(value = "roles", key = "#p0")
    public void delete(Long id) {
        roleRepository.delete(id);
    }
}
