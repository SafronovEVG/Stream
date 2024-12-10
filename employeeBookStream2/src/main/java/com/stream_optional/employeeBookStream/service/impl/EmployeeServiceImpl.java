package com.stream_optional.employeeBookStream.service.impl;

import com.stream_optional.employeeBookStream.domian.Employee;
import com.stream_optional.employeeBookStream.exception.DepartmentNotFoundException;
import com.stream_optional.employeeBookStream.service.api.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<Integer, Employee> EMPLOYEE_MAP = new HashMap<>();

    @Override
    public void addEmployee(Employee employee) {
        EMPLOYEE_MAP.put(employee.getId(), employee);

    }

    @Override
    public Collection<Employee> getAllEmployee() {
        return EMPLOYEE_MAP.values().stream().
                sorted(Comparator.comparing(Employee::getDepartment))
                .collect(Collectors.toList());
    }

    @Override
    public void removeEmployee(Integer id) {
        EMPLOYEE_MAP.remove(id);
    }

    @Override
    public Employee findEmployee(Integer id) {
        return EMPLOYEE_MAP.get(id);
    }

    @Override
    public void setSalaryEmployee(Integer id, Integer salary) {
        EMPLOYEE_MAP.get(id).setSalary(salary);
    }

    @Override
    public void setDepartmentEmployee(Integer id, Integer department) {
        if (department > 0 && department < 5) {
            EMPLOYEE_MAP.get(id).setDepartment(department);
        } else throw new DepartmentNotFoundException();
    }

    @Override
    public Optional<Employee> findMaxSalaryByDepartment(Integer department) {
        return EMPLOYEE_MAP.values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparing(Employee::getSalary));
    }

    @Override
    public Optional<Employee> findMinSalaryByDepartment(Integer department) {
        return EMPLOYEE_MAP.values()
                .stream().filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparing(Employee::getSalary));
    }

    public Collection<Employee> findAllEmployeeByDepartment(Integer department) {
        return EMPLOYEE_MAP.values().stream().filter(employee -> employee.getDepartment()==department)
                .collect(Collectors.toList());
    }
}
