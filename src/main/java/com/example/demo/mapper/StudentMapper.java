package com.example.demo.mapper;


import com.example.demo.model.student;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface StudentMapper{

    ArrayList<student> getStudents();

    void addStudentName(String name, String id);

    void addStudentEmail(String email, String id);

    void updateStudentNameById(String name, String id);

    void updateStudentEmailById(String email, String id);

    void deleteStudentName(String id);

    void deleteStudentEmail(String id);

}