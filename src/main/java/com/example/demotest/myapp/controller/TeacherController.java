package com.example.demotest.myapp.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demotest.myapp.entity.ResponseDto;
import com.example.demotest.myapp.entity.Student;
import com.example.demotest.myapp.entity.Teacher;
import com.example.demotest.myapp.mapper.StudentMapper;
import com.example.demotest.myapp.service.impl.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentMapper studentMapper;

    ResponseDto responseDto = new ResponseDto();



    // 删除学生
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        teacherService.deleteTeacher(id);
    }

    // 修改学生信息
    @PutMapping
    public void updateStudent(@RequestBody Teacher student) {
        teacherService.updateTeacher(student);
    }

    // 查询学生信息
    @GetMapping("/{id}")
    public Teacher getStudentById(@PathVariable int id) {
        return teacherService.getTeacherById(id);
    }
}
