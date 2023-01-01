package com.example.demotest.myapp.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demotest.myapp.entity.Issue;
import com.example.demotest.myapp.entity.ResponseDto;
import com.example.demotest.myapp.mapper.IssueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/issue")
public class IssueController {

    @Autowired
    IssueMapper issueMapper;

    @GetMapping()
    public ResponseDto get(){
        List<Issue> issues = issueMapper.selectList(null);
        ResponseDto<List<Issue>> issueResponseDto = new ResponseDto<>();
        issueResponseDto.setContent(issues);
        return issueResponseDto;
    }

    @GetMapping("/{id}")
    public ResponseDto<List> getByIssueId(@PathVariable("id") Integer id){
        System.out.println(id);
        List<Issue> list = issueMapper.selectList(new QueryWrapper<Issue>().eq("operation_id", id));
        System.out.println(list);
        ResponseDto<List> issueResponseDto = new ResponseDto<List>();
        issueResponseDto.setContent(list);
        return issueResponseDto;
    }

    @PostMapping
    public ResponseDto add(@RequestBody Issue issue){
        ResponseDto issueResponseDto = new ResponseDto<>();
        if(issueMapper.insert(issue)>0){
            issueResponseDto.setMessage("添加成功");
            issueResponseDto.setCode("200");
        }else{
            issueResponseDto.setMessage("添加失败");
            issueResponseDto.setCode("500");
        }
        return issueResponseDto;
    }

    @PutMapping
    public ResponseDto update(@RequestBody Issue issue){
        ResponseDto issueResponseDto = new ResponseDto<>();
        if(issueMapper.insert(issue)>0){
            issueResponseDto.setMessage("添加成功");
            issueResponseDto.setCode("200");
        }else{
            issueResponseDto.setMessage("添加失败");
            issueResponseDto.setCode("500");
        }
        return issueResponseDto;
    }

}
