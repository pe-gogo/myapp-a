package com.example.demotest.myapp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demotest.myapp.entity.Student;
import com.example.demotest.myapp.entity.Teacher;
import com.example.demotest.myapp.entity.User;
import com.example.demotest.myapp.mapper.StudentMapper;
import com.example.demotest.myapp.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private StudentMapper studentMapper;

    public boolean login(User user) {
        Student student = studentMapper.selectOne(new QueryWrapper<Student>().eq("username", user.getUsername()).eq("password", user.getPassword()));
        Teacher teacher = teacherMapper.selectOne(new QueryWrapper<Teacher>().eq("username", user.getUsername()).eq("password", user.getPassword()));
        if(teacher!=null||student!=null){
            return true;
        }
        return false;
    }

    public boolean register(User user) {
        Teacher teacher = teacherMapper.selectOne(new QueryWrapper<Teacher>().eq("username", user.getUsername()).eq("password", user.getPassword()));
        Student student = studentMapper.selectOne(new QueryWrapper<Student>().eq("username", user.getUsername()).eq("password", user.getPassword()));
        if(student!=null || teacher !=null){
            return false;
        }
        System.out.println(user);
        if ("student".equals(user.getType())) {
            return studentMapper.insert(new Student(user.getUsername(), user.getPassword())) > 0;
        } else if("teacher".equals(user.getType())){
            return teacherMapper.insert(new Teacher(user.getUsername(), user.getPassword())) > 0;
        }
        return false;
    }

}
