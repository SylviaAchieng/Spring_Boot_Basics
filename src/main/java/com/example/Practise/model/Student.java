package com.example.Practise.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="student1")
public class Student {


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id //shows that the id is a primary key
    private BigDecimal id;

    private String firstName;

    private String lastName;

    private String location;

    private String email;

    private String password;

    private BigDecimal age;
}
