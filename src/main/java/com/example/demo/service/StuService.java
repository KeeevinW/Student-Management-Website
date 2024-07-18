package com.example.demo.service;


import com.example.demo.mapper.StudentMapper;
import com.example.demo.model.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
public class StuService{

    @Autowired
    private StudentMapper studentMapper;

    public ArrayList<student> getStudents(){
        return studentMapper.getStudents();
    }

    public String getStudentNameByEmail(String email){
        return studentMapper.getStudentNameByEmail(email);
    }

    public String getStudentEmailByName(String name){
        return studentMapper.getStudentEmailByName(name);
    }

    public Map<String, String> getStudentNameAndEmailById(String id){
        return studentMapper.getStudentNameAndEmailById(id);
    }

    public String addStudent(student stu){
        studentMapper.addStudentName(stu.getName(), stu.getId());
        studentMapper.addStudentEmail(stu.getEmail(), stu.getId());
        return "Student added";
    }

    public String updateStudent(student stu){
        if(stu.getEmail()=="" && stu.getName()==""){
            return "Nothing to update";
        }
        if(stu.getEmail()!=""){
            studentMapper.updateStudentEmailById(stu.getEmail(),stu.getId());
        }
        if(stu.getName()!=""){
            studentMapper.updateStudentNameById(stu.getName(),stu.getId());
        }
        return "Student updated";
    }

    public String deleteStudent(String id){
        studentMapper.deleteStudentName(id);
        studentMapper.deleteStudentEmail(id);
        return "Student deleted";
    }
}
