package com.example.springWebFluxExp.entity;


import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;



@Data
@ToString
@Document
public class Employee {

    @MongoId
    private Long id;
    private String name;
    private String code;
    private String departmentName;
}
