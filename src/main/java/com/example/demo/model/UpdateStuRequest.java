package com.example.demo.model;

//This class serves as a data transfer object (DTO) in updateStudent
public class UpdateStuRequest {
    private String name;
    private String email;

    public UpdateStuRequest (String n, String email){
        this.name = n;
        this.email = email;
    }

    public UpdateStuRequest (String str){
        if(str.indexOf("@")==-1){
            this.name = str;
            this.email = "";
        }else {
            this.name = "";
            this.email = str;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
