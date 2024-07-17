package com.example.demo.service;


import com.example.demo.mapper.StudentMapper;
import com.example.demo.model.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StuService{

    @Autowired
    private StudentMapper studentMapper;

    public ArrayList<student> getStudents(){
        return studentMapper.getStudents();
    }

    public String addStudent(student stu){
        studentMapper.addStudents(stu.getName(), stu.getId());
        return "Student added";
    }

    public String updateStudent(student stu){
        studentMapper.updateStudent(stu.getName(), stu.getId());
        return "Student updated";
    }

    public String deleteStudent(String id){
        studentMapper.deleteStudent(id);
        return "Student deleted";
    }
}
