package org.example.courseenrollmentwebsite.service;

import org.example.courseenrollmentwebsite.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CourseService {

    @Autowired
    private ApiService apiService;

    @Autowired
    private CourseMapper courseMapper;

    public ArrayList<String> getStuCourses(String name){
        String url = "http://localhost:8080/api/getidbyname/"+name;
        String id = apiService.getStuIdByName(url);
        if(id.equals("")){
            ArrayList<String> temp = new ArrayList<String>();
            temp.add("No such student");
            return temp;
        }
        return courseMapper.getStuCourses(id);
    }

    public String addCourse(String name, String course){
        String url = "http://localhost:8080/api/getidbyname/"+name;
        String id = apiService.getStuIdByName(url);
        if(id.equals("")){
            return "No such student";
        }

        try {
            courseMapper.addCourse(id, course);
        }catch (DuplicateKeyException e){
            return "This student has already enrolled this course.";
        }catch (DataIntegrityViolationException e){
            return "Please run the student management website in order to add a course for this student";
        }
        return "Course added successfully";
    }
}
