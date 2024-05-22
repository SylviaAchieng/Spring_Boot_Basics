package com.example.Practise.repository;

import com.example.Practise.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

//You have to pass the type and the id in the JpaRepository
@Repository
public interface StudentRepository extends JpaRepository<Student, BigDecimal> {


}
