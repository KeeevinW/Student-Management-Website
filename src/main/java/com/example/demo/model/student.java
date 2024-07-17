package com.example.demo.model;

public class student{
    private String StuName;
    private String StuId;
    private String StuEmail;

    public student(String name, String id, String email) {
        this.StuName = name;
        this.StuId = id;
        this.StuEmail = email;

    }

    public student(String name, String id){
        this.StuName = name;
        this.StuId = id;
        this.StuEmail = "No Email";
    }

    public student(){
        this.StuName = "";
        this.StuId = "";
        this.StuEmail = "";
    }

    public String getId() {
        return StuId;
    }

    public void setId(String id) {
        this.StuId = id;
    }

    public String getName() {
        return StuName;
    }

    public void setName(String name) {
        this.StuName = name;
    }

    public String getEmail(){
        return StuEmail;
    }

    public void setEmail(String email){
        this.StuEmail = email;
    }
}