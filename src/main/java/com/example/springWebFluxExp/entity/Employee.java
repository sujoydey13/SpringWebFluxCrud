package com.example.springWebFluxExp.entity;


import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Table(value="employee")
@Data
@ToString
public class Employee {


    @Id
    private Long id;
    private String name;
    private String code;
    private String departmentName;
}
