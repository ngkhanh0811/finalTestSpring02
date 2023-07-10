package com.example.finaltestspring.repo;

import com.example.finaltestspring.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>, JpaSpecificationExecutor {
//    EmployeeDto getEmployeeById(Long id);
    @Query(value = "from employee e where e.name like %:searchString%")
    List<Employee> searchEmployees(@Param("searchString") String searchString);
}
