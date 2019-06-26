package com.service;

import com.entity.Student;

import java.util.List;

public interface StudentService {

    public Student findById(Long id);

    public void updateByStudent(Student student);

    public List<Student> findStudentAll();
}
