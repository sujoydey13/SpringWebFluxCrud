package com.example.springWebFluxExp.dto;

import lombok.Data;

@Data
public class EmployeeRequestDto {
    private Long id;
    private String name;
    private String code;
    private String departmentName;
}
