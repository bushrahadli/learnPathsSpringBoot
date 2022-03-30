package com.springBoot.learn.learnPathSpring.service;

import com.springBoot.learn.learnPathSpring.entity.Department;
import com.springBoot.learn.learnPathSpring.entity.Student;
import com.springBoot.learn.learnPathSpring.entity.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    List<Student> studentList;
    List<Subject> subjectList;

    @PostConstruct
    public void generateStudents(){
        studentList= new ArrayList<>();
        subjectList= new ArrayList<>();

        Subject subject= new Subject();
        subject.setSubjectId(11);
        subject.setSubjectName("Maths");
        subject.setMarks((float) 80.01);
        subject.setTutorName("John");
        subjectList.add(subject);

        Department department= new Department();
        department.setDeptId(21);
        department.setDeptName("Science");

        Student student= new Student();
        student.setId(1);
        student.setAddress("Ganeshnagar");
        student.setName("Ruksad");
        student.setSubject(subjectList);
        student.setDept(department);
        studentList.add(student);
    }

    @Override
    public Student getStudent(Integer id) {
        Optional<Student> student= studentList.stream().filter(x -> x.getId().equals(id)).findFirst();
        return student.orElse(null);
    }

    @Override
    public List<Student> getAllStudents() {
        if(studentList!=null)
            return studentList;
        else
            return null;
    }

    @Override
    public List<Student> addStudent(List<Student> student){
        studentList.addAll(student);
        return student;
    }

    @Override
    public Student deleteStudent(Integer id) {
        Student s1= getStudent(id);
        studentList.remove(s1);
        return s1;
    }
}
