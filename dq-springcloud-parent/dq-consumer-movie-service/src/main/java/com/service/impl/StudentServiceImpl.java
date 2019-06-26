package com.service.impl;

import com.entity.Student;
import com.repository.StudentRepository;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student findById(Long id) {
        return studentRepository.findOne(id);
    }

    @Override
    @Transactional
    public void updateByStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> findStudentAll() {
        return studentRepository.findAll();
    }
}
