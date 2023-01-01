package com.example.demotest.myapp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @TableId(value = "id", type = IdType.AUTO)
    private String id;
    private String username;
    private String password;
    private LinkedList operationId;

    public Student (String username, String password){
        this.username = username;
        this.password = password;
    }

}
