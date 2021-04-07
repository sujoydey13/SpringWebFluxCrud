package com.example.springWebFluxExp.repository;

import com.example.springWebFluxExp.entity.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface EmployeeRepository extends ReactiveCrudRepository<Employee,Long> {
}
