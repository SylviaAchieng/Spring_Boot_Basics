package com.example.Practise.service;

import com.example.Practise.dto.StudentDto;
import com.example.Practise.mapper.StudentMapper;
import com.example.Practise.model.Student;
import com.example.Practise.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service

public class StudentServiceImplementation implements StudentServiceInterface{


    private static final Logger log = LoggerFactory.getLogger(StudentServiceImplementation.class);

    private StudentRepository studentRepository;

    private StudentMapper studentMapper;



    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
         studentRepository.findAll().forEach(students::add);
         return students;
    }


    public Optional<StudentDto> getStudentById(BigDecimal id){
        Optional<StudentDto> studentDto = studentRepository.findById(id).map(studentMapper::StudentToStudentDto);
  if (studentDto.isPresent()){
      return studentDto;
  }else {
      log.info("Failed to fetched student by Id");
      return null;
  }
    }


    public Student addStudent( Student student){
         Student createdStudent=studentRepository.save(student);
        log.info("Student created successfully");
        return createdStudent;
    }


    public void updateStudent(BigDecimal id, Student student) {
        studentRepository.save(student);
    }


}
