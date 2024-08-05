package org.example.courseenrollmentwebsite.controllers;

import org.example.courseenrollmentwebsite.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/getcourse")
    public ResponseEntity<ArrayList<String>> getStuCourses(@RequestParam("name") String name){
        ArrayList<String> response = courseService.getStuCourses(name);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/addcourse")
    public ResponseEntity<String> addCourse(@RequestParam("course") String course, @RequestParam("name") String name){
        String response = courseService.addCourse(name, course);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
