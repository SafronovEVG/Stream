package com.stream_optional.employeeBookStream.controller;

import com.stream_optional.employeeBookStream.domian.Employee;
import com.stream_optional.employeeBookStream.service.api.EmployeeService;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController  {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam String name, @RequestParam String surname) {
        Employee employee = new Employee(name, surname);
        employeeService.addEmployee(employee);
        return "Поьзователь добавлен в базу";
    }
    @GetMapping("/set-salary")
    public String setSalaryEmployee(@RequestParam Integer id, @RequestParam Integer salary) {
       employeeService.setSalaryEmployee(id, salary);
        return "Зарплата изенена";
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> allEmployee(Integer department) {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam Integer id) {
        employeeService.removeEmployee(id);
        return "Работник удален";
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam Integer id) {
        return employeeService.findEmployee(id);
    }
}

