package com.example.Practise.service;

import com.example.Practise.dto.StudentDto;
import com.example.Practise.model.Student;

import java.util.List;

public interface StudentServiceInterface {

    StudentDto addNewStudent(StudentDto studentDto);

    List<Student> getAllStudents(StudentDto studentDto);
}
