package com.example.finaltestspring.service;

import com.example.finaltestspring.dto.EmployeeDto;
import com.example.finaltestspring.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> gets(EmployeeDto criteria);

    EmployeeDto save(EmployeeDto employeeDto);
    List<Employee> searchEmployees(String x);
}
