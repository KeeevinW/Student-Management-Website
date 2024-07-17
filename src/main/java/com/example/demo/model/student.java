package com.example.demo.model;

public class student{
    private String StuName;
    private String StuId;

    public student(String name, String id) {
        this.StuName = name;
        this.StuId = id;
    }
    public student(String name){
        this.StuName = name;
        this.StuId = "No ID";
    }

    public student(){
        this.StuName = "";
        this.StuId = "";
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
}