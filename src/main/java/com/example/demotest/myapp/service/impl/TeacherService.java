package com.example.demotest.myapp.service.impl;

import com.example.demotest.myapp.entity.Teacher;
import com.example.demotest.myapp.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    public Teacher getTeacherById(int id) {
        return teacherMapper.selectById(id);
    }

    public void addTeacher(Teacher teacher) {
        teacherMapper.insert(teacher);
    }

    public void deleteTeacher(int id) {
        teacherMapper.deleteById(id);
    }

    public void updateTeacher(Teacher teacher) {
        teacherMapper.updateById(teacher);
    }
}
