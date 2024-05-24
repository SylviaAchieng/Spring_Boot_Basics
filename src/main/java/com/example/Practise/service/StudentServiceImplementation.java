package com.example.Practise.service;


import com.example.Practise.dto.StudentDto;
import com.example.Practise.mapper.StudentMapper;
import com.example.Practise.model.Student;
import com.example.Practise.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImplementation implements StudentServiceInterface{


    private static final Logger log = LoggerFactory.getLogger(StudentServiceImplementation.class);


    private final StudentRepository studentRepository;


    private final StudentMapper studentMapper;

    //constructor injection since lombok injection may lead to creating may beans
    public StudentServiceImplementation(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }


    //creating a new student
    public Student addStudent( Student student){
        Student createdStudent = studentRepository.save(student);
        log.info("Student created successfully");
        return createdStudent;
    }

    //getting a list of students
    public List<Student> getAllStudents() {
         return studentRepository.findAll();

    }

    //get student by id
    public Optional<StudentDto> getStudentById(BigDecimal id){
        Optional<StudentDto> studentDto = studentRepository.findById(id).map(studentMapper::StudentToStudentDto);
  if (studentDto.isPresent()){
      return studentDto;
  }else {
      log.info("Failed to fetched student by Id");
      return null;
  }
    }



    public void updateStudent(BigDecimal id, Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(BigDecimal id) {
        studentRepository.deleteById(id);

    }

}
