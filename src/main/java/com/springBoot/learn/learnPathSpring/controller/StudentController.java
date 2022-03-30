package com.springBoot.learn.learnPathSpring.controller;

import com.springBoot.learn.learnPathSpring.entity.Student;
import com.springBoot.learn.learnPathSpring.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class StudentController {

    @Autowired
    public StudentService studentService;
    /**
     *  /students/student/{studentID}    is resource identifier
     *  end point is resource identifier with method and HTTP Verb: Get, Post, Put, Delete, Options, head
     */

    @GetMapping(path= "/students/student/{studentID}") //Resource Identifier
    public Student getStudent(@PathVariable("studentID") Integer id){
        log.info("Fetching Student info with ID and testId: {} {}", id, 100);
        return studentService.getStudent(id);
    }

    @GetMapping(path= "/students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping(path= "/students/student")
    public List<Student> addStudent(@RequestBody  List<Student> student){
        return studentService.addStudent(student);
    }

    @DeleteMapping(path= "/students/{studentID}")
    public Student deleteStudent(@PathVariable("studentID") Integer id){
        return studentService.deleteStudent(id);
    }
}
