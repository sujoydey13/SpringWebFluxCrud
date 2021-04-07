package com.example.springWebFluxExp.service;

import com.example.springWebFluxExp.dto.EmployeeRequestDto;
import com.example.springWebFluxExp.entity.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {
    public Mono<Employee> createEmployee(EmployeeRequestDto employeeRequestDto);
    public Mono<Employee> getEmployeeById(Long id);
    public Mono<Employee> updateEmployeeById(EmployeeRequestDto employeeRequestDto, Long id);
    public Mono<Employee> deleteEmployeeById(Long id);
    public Flux<Employee> findAllEmployee();
}
