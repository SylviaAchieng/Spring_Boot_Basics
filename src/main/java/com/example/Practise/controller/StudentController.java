package com.example.Practise.controller;

import com.example.Practise.dto.StudentDto;
import com.example.Practise.model.Student;
import com.example.Practise.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/greetings") //@RequestMapping maps to a Get method by default
@Slf4j
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


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
            log.info(student.toString());
            Student addedStudent= studentService.addStudent(student);
//            log.info(addedStudent.toString());
            return new ResponseEntity<>(addedStudent,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //handler method to handle list of students and return mode and view
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Optional<StudentDto>> getStudentById(@PathVariable BigDecimal id){

        try {
            Optional<StudentDto> student= studentService.getStudentById(id);
            return new ResponseEntity<>(student, HttpStatus.OK);

        }catch (Exception e){
            return  new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/students/{id}")
    public void updateStudent(@RequestBody Student student, @PathVariable BigDecimal id){
        studentService.updateStudent(id, student);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudentById(@PathVariable BigDecimal id){
        studentService.deleteStudentById(id);
    }



}
