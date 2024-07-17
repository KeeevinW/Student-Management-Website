package com.example.demo.controller;

import com.example.demo.model.student;
import com.example.demo.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;



@RestController
@RequestMapping("/api")
public class ApiController {

//    private ArrayList<student> students = new ArrayList<>();

    @Autowired
    private StuService stuService;

    @GetMapping("/student") //GET
    public ResponseEntity<ArrayList<student>> getStudents() {
        ArrayList<student> responses = stuService.getStudents();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @PutMapping("/student/{id}") //PUT
    public String updateStudent(@PathVariable String id, @RequestBody String name) {
        return stuService.updateStudent(new student(name, id));
        //TODO: case if the student is not found
    }

    @DeleteMapping("/student/{id}") //DELETE
    public String deleteStudent(@PathVariable String id) {
        return stuService.deleteStudent(id);
    }
    
    @PostMapping(value = "/student", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE) //POST
    public ResponseEntity<String> addStudent(@ModelAttribute student stu){
        String response = stuService.addStudent(stu);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}