package com.example.Practise.repository;

import com.example.Practise.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.stream.DoubleStream;

//You have to pass the type and the id in the JpaRepository
@Repository //not necessary since it's already extending the jpa repository
public interface StudentRepository extends JpaRepository<Student, BigDecimal> {

    //you can specify the methods here if you are using another column which is not the id
    // Student findByEmail(email) - this will find student by email
}
