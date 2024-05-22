package com.example.Practise.service;

import com.example.Practise.dto.StudentDto;
import com.example.Practise.model.Student;
import com.example.Practise.repository.StudentRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import java.math.BigDecimal;
import java.util.List;
@Service
public class StudentServiceImplementation implements StudentServiceInterface{


    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentDto addNewStudent(StudentDto studentDto) {

        return null;
    }

    @Override
    public List<Student> getAllStudents(StudentDto studentDto) {
        return studentRepository.findAll();
    }


}
