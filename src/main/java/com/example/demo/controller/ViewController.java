package com.example.demo.controller;

import com.example.demo.model.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Map;

@Controller
public class ViewController{
    
    @GetMapping("/")
    public String showForm() {
        return "index";  // Render the index.html form template
    }

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/student")
    public String GetStu (Model model){
        String apiUrl = "http://localhost:8080/api/student";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type","application/json");
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<ArrayList<student>> response = restTemplate.exchange(apiUrl, HttpMethod.GET, requestEntity, new ParameterizedTypeReference<ArrayList<student>>() {});

        model.addAttribute("students",response.getBody());
        return "GetStudents";
    }

    @GetMapping("/student/byemail")
    public String GetStuByE (Model model, @RequestParam("email") String email){ //Get student's name by email
        String apiUrl = "http://localhost:8080/api/student/byemail";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        HttpEntity<String> response = restTemplate.exchange(apiUrl + "?email=" + email, HttpMethod.GET, requestEntity, String.class);

        model.addAttribute("StuName", response.getBody());
        return "GetStudentNameByEmail";
    }

    @GetMapping("/student/byname")
    public String GetStuByN (Model model, @RequestParam("name") String name){ //Get student's email by name
        String apiUrl = "http://localhost:8080/api/student/byname";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        HttpEntity<String> response = restTemplate.exchange(apiUrl + "?name=" + name, HttpMethod.GET, requestEntity, String.class);


        model.addAttribute("StuEmail", response.getBody());
        return "GetStudentEmailByName";
    }

    @GetMapping("/student/byid")
    public String GetStuByI (Model model, @RequestParam("id") String id){
        String apiUrl = "http://localhost:8080/api/student/byid";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(headers);
        HttpEntity<Map<String, String>> response = restTemplate.exchange(apiUrl + "?id=" + id, HttpMethod.GET, requestEntity, new ParameterizedTypeReference<Map<String, String>>() {});

        model.addAttribute("StuNameAndEmail", response.getBody());
        return "getStudentNameAndEmailById";
    }

    @PostMapping("/student")
    public String AddStu (Model model, @ModelAttribute student stu){

        String apiUrl = "http://localhost:8080/api/student";

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("name", stu.getName());
        map.add("email", stu.getEmail());
        map.add("id", stu.getId());
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(map, headers);

        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);
        
        model.addAttribute("AddStatus",response.getBody());
        return "AddStudents";
    }


}