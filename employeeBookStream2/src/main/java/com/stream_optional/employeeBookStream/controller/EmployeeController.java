package com.stream_optional.employeeBookStream.controller;

import com.stream_optional.employeeBookStream.domian.Employee;
import com.stream_optional.employeeBookStream.exception.DepartmentNotFoundException;
import com.stream_optional.employeeBookStream.service.api.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
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

    @GetMapping("/all")
    public Collection<Employee> allEmployee(Integer department) {
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

    @GetMapping("/set-salary")
    public String setSalaryEmployee(@RequestParam Integer id, @RequestParam Integer salary) {
        employeeService.setSalaryEmployee(id, salary);
        return "Зарплата изенена";
    }

    @GetMapping("/set-department")
    public String setDepartmentEmployee(@RequestParam Integer id, @RequestParam Integer department) {
        try {
            employeeService.setDepartmentEmployee(id, department);
            return "Отдел у работника изменен";
        } catch (DepartmentNotFoundException e) {
            return "Такого отдела не существует";
        }
    }

    @GetMapping("/max-salary")
    public Optional<Employee> findMaxSalaryByDepartment(@RequestParam Integer departmentId) {
        return employeeService.findMaxSalaryByDepartment(departmentId);
    }

    @GetMapping("/min-salary")
    public Optional<Employee> findMinSalaryByDepartment(@RequestParam Integer departmentId) {
        return employeeService.findMinSalaryByDepartment(departmentId);
    }

}

