package com.example.demotest.myapp.service.impl;

import com.example.demotest.myapp.entity.Student;
import com.example.demotest.myapp.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public Student getStudentById(int id) {
        return studentMapper.selectById(id);
    }

    public void addStudent(Student student) {
        studentMapper.insert(student);
    }

    public void deleteStudent(int id) {
        studentMapper.deleteById(id);
    }

    public void updateStudent(Student student) {
        studentMapper.updateById(student);
    }
}
