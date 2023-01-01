package com.example.demotest.myapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String username;
    private String password;
    private LinkedList operationId;

    public Student (String username, String password){
        this.username = username;
        this.password = password;
    }

}
