package com.example.demotest.myapp.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demotest.myapp.entity.ResponseDto;
import com.example.demotest.myapp.entity.Student;
import com.example.demotest.myapp.mapper.StudentMapper;
import com.example.demotest.myapp.service.impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentMapper studentMapper;
    // 添加学生
    @PostMapping("/addStudent")
    public ResponseDto addStudent(@RequestBody Student student) {
        Student student2 = studentMapper.selectOne(new QueryWrapper<Student>().eq("username", student.getUsername()).eq("password", student.getPassword()));
        ResponseDto responseDto = new ResponseDto();
        if(student2!=null) {
            responseDto.setMessage("已存在用户");
        }else{
            int insert = studentMapper.insert(student);
            responseDto.setMessage("添加成功");
        }
        return responseDto;
    }

    @GetMapping()
    public ResponseDto getStudentById() {
        ResponseDto objectResponseDto = new ResponseDto<>();
        List<Student> students = studentMapper.selectList(null);
        objectResponseDto.setContent(students);
        return objectResponseDto;
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
