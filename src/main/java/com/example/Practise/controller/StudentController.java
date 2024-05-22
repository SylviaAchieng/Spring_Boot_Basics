package com.example.Practise.controller;

import com.example.Practise.dto.StudentDto;
import com.example.Practise.model.Student;
import com.example.Practise.repository.StudentRepository;
import com.example.Practise.service.StudentServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/greetings") //@RequestMapping maps to a Get method by default
@RequiredArgsConstructor
@Slf4j
public class StudentController {

    @Autowired
    private final StudentServiceInterface studentServiceInterface;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/hello")
    public String greetings(){
        return "Hello Silvia, Welcome to Turnkey Africa";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "This is the Turnkey Africa Limited homepage";
    }
    @PostMapping("add")
    public StudentDto addNewStudent(@RequestBody StudentDto studentDto){
        Student student = new Student();
        student.getFirstName();
        return studentServiceInterface.addNewStudent(studentDto);
    }

    //handler method to handle list of students and return mode and view
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        List<Student> students = studentRepository.findAll();

        return students;
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable BigDecimal id){
        return studentRepository.findById(id).get();
    }

}
