package com.service.impl;

import com.entity.Department;
import com.google.gson.Gson;
import com.repository.DepartmentRepository;
import com.repository.RedisRepository;
import com.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {


    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private RedisRepository<Department> redisRepository;

    @Override
    public Department addDepartment(Department department) {
        Department newDepartment = departmentRepository.save(department);
        if (!ObjectUtils.isEmpty(newDepartment))
            redisRepository.add(String.valueOf(newDepartment.getId()), 30L, newDepartment);
        return newDepartment;
    }

    @Override
    public Department findDepartmentById(Long id) {
        Department department =  redisRepository.get(String.valueOf(id), Department.class);
        if (ObjectUtils.isEmpty(department)){
            department = departmentRepository.findOne(id);
            if (!ObjectUtils.isEmpty(department))
                redisRepository.add(String.valueOf(id), 30L,department);
        }
        return department;
    }

    @Override
    public Department updateDepartment(Department department) {
        if (!ObjectUtils.isEmpty(department)){
            redisRepository.delete(String.valueOf(department.getId()));
            redisRepository.add(String.valueOf(department.getId()), 30L, department);
        }
        return departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(Long id) {
        redisRepository.delete(String.valueOf(id));
        departmentRepository.delete(id);
    }
}
