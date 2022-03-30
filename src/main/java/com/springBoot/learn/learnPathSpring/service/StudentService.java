package com.springBoot.learn.learnPathSpring.service;

import com.springBoot.learn.learnPathSpring.entity.Student;

import java.util.List;

public interface StudentService {

    Student getStudent(Integer id);
    List<Student> getAllStudents();
    List<Student> addStudent(List<Student> student);
    Student deleteStudent(Integer id);
}
