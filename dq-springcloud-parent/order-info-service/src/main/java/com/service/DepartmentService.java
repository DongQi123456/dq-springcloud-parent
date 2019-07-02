package com.service;

import com.entity.Department;

public interface DepartmentService {

    Department addDepartment(Department department);

    Department findDepartmentById(Long id);

    Department updateDepartment(Department department);

    void deleteDepartment(Long id);

}
