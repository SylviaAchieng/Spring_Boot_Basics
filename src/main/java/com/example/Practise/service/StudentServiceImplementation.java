package com.example.Practise.service;


import com.example.Practise.dto.StudentDto;
import com.example.Practise.mapper.StudentMapper;
import com.example.Practise.model.Student;
import com.example.Practise.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class StudentServiceImplementation implements StudentService {

    private  StudentRepository studentRepository;


    private  StudentMapper studentMapper;

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
        Optional<Student> studentFromDb = studentRepository.findById(id);
        if (studentFromDb.isPresent()) {
            student.setId(studentFromDb.get().getId());
            studentRepository.save(student);
        } else {
            throw new RuntimeException("Student not found");
        }

    }

    @Override
    public void deleteStudentById(BigDecimal id) {
        Optional<Student> studentFromD = studentRepository.findById(id);
        if (studentFromD.isPresent()){
            studentRepository.deleteById(id);
        } else {
            throw new RuntimeException("student not found");
        }


    }

//    @Override
//    public Student addListOfStudents(List<Student> student) {
//        List<Student> addedStudents = student.stream().collect(Collectors.toList());
//        studentRepository.stream().collect(Collectors.toList()).saveAll(addedStudents);
//
//    }

    // adding a list of students
    public List<Student> addStudentList(List<Student> students)
    {
        return students.stream().map(studentRepository::save).toList();
        //return studentRepository.saveAll(students);

    }


}
