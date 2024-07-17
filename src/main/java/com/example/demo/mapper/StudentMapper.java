package com.example.demo.mapper;


import com.example.demo.model.student;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface StudentMapper{

    ArrayList<student> getStudents();

    void addStudents(String name, String id);

    void updateStudent(String name, String id);

    void deleteStudent(String id);

}