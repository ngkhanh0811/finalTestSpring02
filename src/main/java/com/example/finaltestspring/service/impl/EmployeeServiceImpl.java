package com.example.finaltestspring.service.impl;

import com.example.finaltestspring.dto.EmployeeDto;
import com.example.finaltestspring.entity.Employee;
import com.example.finaltestspring.mapper.EmployeeMapper;

import com.example.finaltestspring.repo.EmployeeRepo;
import com.example.finaltestspring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper mapper;
    @Autowired
    private EmployeeRepo repo;

    @Override
    public List<EmployeeDto> gets(EmployeeDto criteria){
        Pageable pageable = PageRequest.of(criteria.getPageNumber(), criteria.getPageSize());
        Page<Employee> employeeList = repo.findAll(pageable);
        return employeeList.getContent()
                .stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }


    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        // if primary key existed -> update
        // if primary key value is null -> add
        Employee employee = mapper.dtoToEntity(employeeDto);
        if (Objects.isNull(employee)){
            return null;
        } else{
            Employee returnEntity = repo.save(employee);
            return mapper.entityToDto(returnEntity);
        }
    }

    public List<Employee> searchEmployees(String x){
        List<Employee> employee = repo.searchEmployees(x);
        return employee;
    }
}
