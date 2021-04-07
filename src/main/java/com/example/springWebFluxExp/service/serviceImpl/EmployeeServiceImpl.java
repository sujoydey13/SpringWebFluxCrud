package com.example.springWebFluxExp.service.serviceImpl;

import com.example.springWebFluxExp.dto.EmployeeRequestDto;
import com.example.springWebFluxExp.entity.Employee;
import com.example.springWebFluxExp.repository.EmployeeRepository;
import com.example.springWebFluxExp.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Mono<Employee> createEmployee(EmployeeRequestDto employeeRequestDto){
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeRequestDto,employee);
        Mono<Employee> savedEmployee = employeeRepository.save(employee);
        return savedEmployee;
    }

    @Override
    public Mono<Employee> getEmployeeById(Long id){
        Mono<Employee> employeeMono = employeeRepository.findById(id);
        return employeeMono;
    }

    @Override
    public Mono<Employee> updateEmployeeById(EmployeeRequestDto employeeRequestDto, Long id){
        Mono<Employee> employeeMono = employeeRepository.findById(id).doOnSuccess(System.out::println);
        employeeMono.subscribe(emp -> {
            emp.setName(employeeRequestDto.getName());
            emp.setCode(employeeRequestDto.getCode());
            emp.setDepartmentName(employeeRequestDto.getDepartmentName());
            System.out.println("Before");
            employeeRepository.save(emp).subscribe();
            System.out.println("After");
        });
        return employeeMono;
    }

    @Override
    public Mono<Employee> deleteEmployeeById(Long id){
        Mono<Employee> employeeMono = employeeRepository.findById(id);
        employeeRepository.deleteById(id).subscribe(emp -> System.out.println("Subscribed"),err-> System.out.println("Error"),()-> System.out.println("deleted successfully"));
        return employeeMono;
    }

    @Override
    public Flux<Employee> findAllEmployee(){
        Flux<Employee> employeeFlux = employeeRepository.findAll();
        return employeeFlux;
    }
}
