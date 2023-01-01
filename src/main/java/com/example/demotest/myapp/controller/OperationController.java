package com.example.demotest.myapp.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demotest.myapp.entity.Issue;
import com.example.demotest.myapp.entity.Operation;
import com.example.demotest.myapp.entity.ResponseDto;
import com.example.demotest.myapp.entity.Student;
import com.example.demotest.myapp.mapper.OperationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liqingyuan
 * @since 2022-12-31
 */
@RestController
@RequestMapping("/operation")
public class OperationController {

    @Autowired
    OperationMapper operationMapper;

    @GetMapping()
    public ResponseDto get(){
        List operation = (List) operationMapper.selectList(null);
        ResponseDto<List> operationResponseDto = new ResponseDto<>();
        operationResponseDto.setContent(operation);
        return operationResponseDto;
    }

    @GetMapping("/{id}")
    public ResponseDto getByStudentId(@PathVariable("id") Integer id){
        List operation = (List) operationMapper.selectList(new QueryWrapper<Operation>().eq("student_id",id));
        ResponseDto<List> operationResponseDto = new ResponseDto<>();
        operationResponseDto.setContent(operation);
        return operationResponseDto;
    }

    @PostMapping
    public ResponseDto add(@RequestBody Operation operation){
        ResponseDto operationResponseDto = new ResponseDto<>();
        if(operationMapper.insert(operation)>0){
            operationResponseDto.setMessage("添加成功");
            operationResponseDto.setCode("200");
        }else{
            operationResponseDto.setMessage("添加失败");
            operationResponseDto.setCode("500");
        }
        return operationResponseDto;
    }

    @PutMapping
    public ResponseDto update(@RequestBody Operation operation){
        ResponseDto issueResponseDto = new ResponseDto<>();
        if(operationMapper.updateById(operation)>0){
            issueResponseDto.setMessage("修改成功");
            issueResponseDto.setCode("200");
        }else{
            issueResponseDto.setMessage("修改失败");
            issueResponseDto.setCode("500");
        }
        return issueResponseDto;
    }

}
