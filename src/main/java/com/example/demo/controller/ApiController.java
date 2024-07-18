package com.example.demo.controller;

import com.example.demo.model.UpdateStuRequest;
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

    @GetMapping("/student/byemail")
    public ResponseEntity<String> getStudentNameByEmail(@RequestParam("email") String email) {
        String response = stuService.getStudentNameByEmail(email);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/student/byname")
    public ResponseEntity<String> getStudentEmailByName(@RequestParam("name") String name) {
        String response = stuService.getStudentEmailByName(name);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/student/{id}") //PUT
    public String updateStudent(@PathVariable String id, @RequestBody UpdateStuRequest stu) {
        System.out.println(stu.getName());
        System.out.println(stu.getEmail());
        return stuService.updateStudent(new student(stu.getName(), id, stu.getEmail()));

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