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
public class StudentDto {
    private BigDecimal id;

    private String firstname;

    private String lastname;

    private String email;

}
