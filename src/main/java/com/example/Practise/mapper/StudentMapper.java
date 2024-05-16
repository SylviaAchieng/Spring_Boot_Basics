package com.example.Practise.mapper;

import com.example.Practise.dto.StudentDto;
import com.example.Practise.model.Student;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

//to show the spring manages the lifecycle of generated mapper implementation
@Mapper(componentModel = "spring")
@DecoratedWith(value = StudentMapperDecorator.class)

public interface StudentMapper {
    //create instance of student mapper
    StudentMapper INSTANCE= Mappers.getMapper(StudentMapper.class);

    //map student to studentdto , return studentDto
    StudentDto StudentToStudentDto (Student student);

    //map StudentDto to student
    Student StudentDtoToStudent (StudentDto studentDto);


}
