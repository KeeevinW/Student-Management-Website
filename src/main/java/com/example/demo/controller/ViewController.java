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
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

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

//    @PutMapping("/student/{id}")
//    public String UpdateStu (Model model, @PathVariable String id, @RequestBody String name){
//        String apiUrl = "http://localhost:8080/api/student/"+id;
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Content-Type","application/json");
//        HttpEntity<String> requestEntity = new HttpEntity<>(name, headers);
//        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.PUT, requestEntity, String.class);
//
//        model.addAttribute("UpdateStatus", response.getBody());
//        return "UpdateStudents";
//    }
//
//    @DeleteMapping("/student/{id}")
//    public String DeleteStu (Model model, @PathVariable String id){
//        String apiUrl = "http://localhost:8080/api/student"+id;
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Content-Type","application/json");
//        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
//        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.DELETE, requestEntity, String.class);
//
//
//        model.addAttribute("DeleteStatus",response.getBody());
//        return "DeleteStudents";
//    }

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