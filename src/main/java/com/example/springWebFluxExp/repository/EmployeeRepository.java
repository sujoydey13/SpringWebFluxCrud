package com.example.springWebFluxExp.repository;

import com.example.springWebFluxExp.entity.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee,Long> {
}
