package com.example.finaltestspring.mapper;

import com.example.finaltestspring.dto.EmployeeDto;
import com.example.finaltestspring.entity.Employee;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;

@Mapper(componentModel= "spring")
public interface EmployeeMapper {
    Employee dtoToEntity(EmployeeDto employeeDto);
    EmployeeDto entityToDto(Employee employee);
}
