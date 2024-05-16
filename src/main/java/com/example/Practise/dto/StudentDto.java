package com.example.Practise.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

//what you want to display to the users
public class StudentDto {
    private BigDecimal id;

    private String firstname;

    private String lastname;

    private String email;

}
