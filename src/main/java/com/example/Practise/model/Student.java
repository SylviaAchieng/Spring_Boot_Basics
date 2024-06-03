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

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name="location")
    private String location;

    @Column(unique = true)
    private String email;

    @Column(name = "password")
    private String password;

//    @Column(name = "date_of_birth")
//    private String dateOfBirth;

    //@Transient automatically calculates the age if the date of birth is provided
//    @Transient
    private BigDecimal age;


    //    public BigDecimal getAge(){
//        return BigDecimal.valueOf(Period.between(LocalDate.parse(dateOfBirth), LocalDate.now()).getYears());
//    }
}
