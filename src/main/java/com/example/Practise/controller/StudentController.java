package com.example.Practise.controller;

import com.example.Practise.dto.StudentDto;
import com.example.Practise.model.Student;
import com.example.Practise.repository.StudentRepository;
import com.example.Practise.service.StudentServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/greetings") //@RequestMapping maps to a Get method by default
@RequiredArgsConstructor
@Slf4j
public class StudentController {
    @Autowired
    private StudentServiceInterface studentServiceInterface;



//    private  final StudentRepository studentRepository;

    @GetMapping("/hello")
    public String greetings(){
        return "Hello Silvia, Welcome to Turnkey Africa";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "This is the Turnkey Africa Limited homepage";
    }

    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        try {
            Student addedStudent=studentServiceInterface.addStudent(student);
            return new ResponseEntity<>(addedStudent,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //handler method to handle list of students and return mode and view
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentServiceInterface.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Optional<StudentDto>> getStudentById(@PathVariable BigDecimal id){

    try {
        Optional<StudentDto> student=studentServiceInterface.getStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);

    }catch (Exception e){
       return  new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }

    @PutMapping("/students/{id}")
    public void updateStudent(@RequestBody Student student, @PathVariable BigDecimal id){
        studentServiceInterface.updateStudent(id, student);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudentById(@PathVariable BigDecimal id){
        studentServiceInterface.deleteStudentById(id);
    }



}
