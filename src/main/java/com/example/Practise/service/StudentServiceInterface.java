package com.example.Practise.service;

import com.example.Practise.dto.StudentDto;
import com.example.Practise.model.Student;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


public interface StudentServiceInterface {


    List<Student> getAllStudents();


    Optional<StudentDto> getStudentById(BigDecimal id);

    Student addStudent(Student student);

    void updateStudent(BigDecimal id, Student student);
}
