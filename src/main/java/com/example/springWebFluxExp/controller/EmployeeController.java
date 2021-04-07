package com.example.springWebFluxExp.controller;

import com.example.springWebFluxExp.dto.EmployeeRequestDto;
import com.example.springWebFluxExp.entity.Employee;
import com.example.springWebFluxExp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "employee/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Employee> create(@RequestBody EmployeeRequestDto requestDto){
        return employeeService.createEmployee(requestDto);
    }

    @RequestMapping(value="employee/{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Employee> getEmployeeById(@PathVariable("id") Long id){
        return employeeService.getEmployeeById(id);
    }

    @RequestMapping(value="employee/{id}",method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Employee> updateEmployeeById(@PathVariable("id") Long id,@RequestBody EmployeeRequestDto employeeRequestDto){
        return employeeService.updateEmployeeById(employeeRequestDto,id);
    }

    @RequestMapping(value = "employee/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Employee> deleteEmployee(@PathVariable("id") Long id){
        return employeeService.deleteEmployeeById(id);
    }

    @RequestMapping(value="employee/allEmployee",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Employee> getAllEmployee(){
        return employeeService.findAllEmployee();
    }
}
