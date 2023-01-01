package com.example.demotest.myapp.controller;

import com.example.demotest.myapp.entity.Student;
import com.example.demotest.myapp.mapper.StudentMapper;
import com.example.demotest.myapp.service.impl.StudentService;
import com.example.demotest.myapp.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentMapper studentMapper;
    // 添加学生
    @PostMapping
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    // 删除学生
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentMapper.deleteById(id);
    }

    // 修改学生信息
    @PutMapping
    public void updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
    }

    // 查询学生信息
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

}
