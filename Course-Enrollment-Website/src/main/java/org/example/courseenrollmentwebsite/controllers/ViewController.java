package org.example.courseenrollmentwebsite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Controller
public class ViewController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/")
    public String showForm() {
        return "index";  // Render the index.ftl form template
    }

    @GetMapping("/getcourse")
    public String getCourse(Model model, @RequestParam("name") String name){
        String apiUrl = "http://localhost:8081/api/getcourse";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<ArrayList<String>> requestEntity = new HttpEntity<>(headers);
        HttpEntity<ArrayList<String>> response = restTemplate.exchange(apiUrl + "?name=" + name, HttpMethod.GET, requestEntity, new ParameterizedTypeReference<ArrayList<String>>() {});

        model.addAttribute("StuCourse", response.getBody());

        return "GetStudentCourses";
    }

    @PostMapping("/addcourse")
    public String addCourse(Model model, @RequestParam("course") String course, @RequestParam("name") String name){
        String apiurl = "http://localhost:8081/api/addcourse";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<String> requestEneity = new HttpEntity<>(headers);
        HttpEntity<String> response = restTemplate.exchange(apiurl+"?course="+course+"&name="+name, HttpMethod.POST, requestEneity, String.class);

        model.addAttribute("AddCourse", response.getBody());

        return "AddCourse";
    }

}
