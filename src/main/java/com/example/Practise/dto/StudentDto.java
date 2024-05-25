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

//what you want to display to t
public class StudentDto {

    private BigDecimal id;

    private String firstName;

    private String lastName;

    private String email;

}
