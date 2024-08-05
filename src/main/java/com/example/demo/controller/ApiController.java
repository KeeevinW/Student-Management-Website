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
import java.util.Map;


@RestController
@RequestMapping("/api")
public class ApiController {

//    private ArrayList<student> students = new ArrayList<>();

    @Autowired
    private StuService stuService;

    @GetMapping("/getstudent") //GET
    public ResponseEntity<ArrayList<student>> getStudents() {
        ArrayList<student> responses = stuService.getStudents();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping("/getstudent/byemail")
    public ResponseEntity<String> getStudentNameByEmail(@RequestParam("email") String email) {
        String response = stuService.getStudentNameByEmail(email);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getstudent/byname")
    public ResponseEntity<String> getStudentEmailByName(@RequestParam("name") String name) {
        String response = stuService.getStudentEmailByName(name);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getstudent/byid")
    public ResponseEntity<Map<String, String>> getStudentNameAndEmailById(@RequestParam("id") String id){
        Map<String, String> response = stuService.getStudentNameAndEmailById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getidbyname/{name}")
    public String getStuIdByName(@PathVariable String name){
        if(name == ""){
            return "Please enter the student's name";
        }else{
            return stuService.getStudentIdByName(name);
        }
    }

    @PutMapping("/updatestudent/{id}") //PUT
    public String updateStudent(@PathVariable String id, @RequestBody UpdateStuRequest stu) {
        if(id == ""){
            return "Please enter the student's id";
        }else{
            return stuService.updateStudent(new student(stu.getName(), id, stu.getEmail()));
        }
    }

    @DeleteMapping("/deletestudent/{id}") //DELETE
    public String deleteStudent(@PathVariable String id) {
        return stuService.deleteStudent(id);
    }
    
    @PostMapping(value = "/addstudent", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE) //POST
    public ResponseEntity<String> addStudent(@ModelAttribute student stu){
        String response = stuService.addStudent(stu);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}