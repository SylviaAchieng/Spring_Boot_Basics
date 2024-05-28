package com.example.Practise.service;

import com.example.Practise.dto.StudentDto;
import com.example.Practise.model.Student;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


public interface StudentService {


    List<Student> getAllStudents();


    Optional<StudentDto> getStudentById(BigDecimal id);

    Student addStudent(Student student);

    void updateStudent(BigDecimal id, Student student);

    void deleteStudentById(BigDecimal id);




    List<Student> addStudentList(List<Student> students);
}
