package org.example.courseenrollmentwebsite.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface CourseMapper {

    public ArrayList<String> getStuCourses(String id);

    public void addCourse(String id, String course);
}
