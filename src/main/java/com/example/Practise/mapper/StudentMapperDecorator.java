package com.example.Practise.mapper;

import com.example.Practise.dto.StudentDto;
import com.example.Practise.model.Student;
import lombok.experimental.Delegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class StudentMapperDecorator implements StudentMapper{
    @Autowired
    @Qualifier("delegate") //specify the type of bean
    private StudentMapper studentMapper;


    //map student to StudentDto
    public StudentDto StudentToStudentDto (Student student){
       StudentDto studentDto = studentMapper.StudentToStudentDto(student);

       return studentDto;
    }
    //map StudentDto to student
    public Student StudentDtoToStudent (StudentDto studentDto){
        Student student = studentMapper.StudentDtoToStudent(studentDto);

        return student;
    }
}
