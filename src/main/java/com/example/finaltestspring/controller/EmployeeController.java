package com.example.finaltestspring.controller;

import com.example.finaltestspring.dto.EmployeeDto;
import com.example.finaltestspring.entity.Employee;
import com.example.finaltestspring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

@Controller
public class EmployeeController extends BaseController {
    @Autowired
    private EmployeeService employeeService;

    //Get all
    @GetMapping(value="/employees")
    public ModelAndView gets(@RequestParam(required = false) String searchString, HttpServletRequest request){
        EmployeeDto criteria = new EmployeeDto();
        criteria.setPageSize(commonProperties.getDefaultPageSize());
        criteria.setPageNumber(commonProperties.getDefaultPageNumber());
        ModelAndView view = new ModelAndView("pages/list.jsp");
        if (searchString == null || searchString.trim().isEmpty()) {
            List<EmployeeDto> employeeDtoList = employeeService.gets(criteria);
            view.addObject("employees", employeeDtoList);
        } else {
            List<Employee> employeeDtoListByName = employeeService.searchEmployees(searchString);
            view.addObject("employees", employeeDtoListByName);
        }
        return view;
    }

    //Create new
    @GetMapping("/create")
    public ModelAndView get(HttpServletRequest request){
        EmployeeDto employeeDto = new EmployeeDto();
        ModelAndView view = new ModelAndView("pages/createForm.jsp");
        view.addObject("employeeDto", employeeDto);
        return view;
    }

    @PostMapping("/create")
    public RedirectView createNewItem(@ModelAttribute EmployeeDto employeeDto, HttpServletRequest request){
        EmployeeDto employeeDto1 = employeeService.save(employeeDto);
        if (Objects.isNull(employeeDto1)){
            RedirectView view = new RedirectView("pages/createForm.jsp");
            return view;
        }
        return new RedirectView("/employees");
    }
}