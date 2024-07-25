package com.example.demo.service;

import com.example.demo.mapper.StudentMapper;
import com.example.demo.model.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Service
public class StuService{

    private final SecretKey secretKey;

    @Autowired
    public StuService(SecretKey secretKey) {
        this.secretKey = secretKey;
    }

    @Autowired
    private StudentMapper studentMapper;

    public ArrayList<student> getStudents(){
        ArrayList<student> students_temp = studentMapper.getStudents();
        for(student t: students_temp){
            t.setId(decrypt(t.getId()));
        }
        return students_temp;
    }

    public String getStudentNameByEmail(String email){
        String result = studentMapper.getStudentNameByEmail(email);
        return (result!=null)? result : "No such student.";
    }

    public String getStudentEmailByName(String name){
        String result = studentMapper.getStudentEmailByName(name);
        return (result!=null)? result : "No student found / This student doesn't have an email address.";
    }

    public Map<String, String> getStudentNameAndEmailById(String id){
        id = encrypt(id);
        Map<String, String> result = studentMapper.getStudentNameAndEmailById(id);
        if(result == null) {
            Map<String, String> noStu = new HashMap<>();
            noStu.put("StuName", "No such student");
            noStu.put("StuEmail", "No such student");
            return noStu;
        }
        return result;
    }

    public String addStudent(student stu){
        stu.setId(encrypt(stu.getId()));

        try{
            studentMapper.addStudentName(stu.getName(), stu.getId());
            studentMapper.addStudentEmail(stu.getEmail(), stu.getId());
            return "Student added";
        }catch (DuplicateKeyException e){
            return "Failed to add the student: duplicated ID";
        }

    }

    public String updateStudent(student stu){
        stu.setId(encrypt(stu.getId()));

        if(stu.getId().isEmpty() || (stu.getEmail().isEmpty() && stu.getName().isEmpty())){
            return "Nothing to update, please enter information to be updated at least one of the two input fields above.";
        }

        Map<String, String> result = studentMapper.getStudentNameAndEmailById(stu.getId());
        if(result == null) return "No matching student ID";

        if(stu.getEmail().isEmpty()){
            studentMapper.updateStudentEmailById(stu.getEmail(),stu.getId());
        }
        if(!stu.getName().isEmpty()){
            studentMapper.updateStudentNameById(stu.getName(),stu.getId());
        }
        return "Student updated";
    }

    public String deleteStudent(String id){
        Map<String, String> result = studentMapper.getStudentNameAndEmailById(id);
        if(result == null) return "Student not found";

        id=encrypt(id);
        studentMapper.deleteStudentName(id);
        studentMapper.deleteStudentEmail(id);
        return "Student deleted";
    }

    //Encrypt the text (id)
    public String encrypt(String secretMessage){
        try{
            Cipher encryptCipher = Cipher.getInstance("AES");
            encryptCipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] secretMessageBytes = secretMessage.getBytes(StandardCharsets.UTF_8);
            byte[] encryptedMessageBytes = encryptCipher.doFinal(secretMessageBytes);
            return Base64.getEncoder().encodeToString(encryptedMessageBytes);

        }catch (Exception e){
            throw new RuntimeException("Error encrypting data", e);
        }

    }

    //decrypt the text (id)
    public String decrypt(String encryptedMessage){
        byte[] encryptedMessageBytes = Base64.getDecoder().decode(encryptedMessage);
        try{
            Cipher decryptCipher = Cipher.getInstance("AES");
            decryptCipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedMessageBytes = decryptCipher.doFinal(encryptedMessageBytes);
            return new String(decryptedMessageBytes, StandardCharsets.UTF_8);
        }catch (Exception e){
            throw new RuntimeException("Error decrypting data", e);
        }
    }
}
